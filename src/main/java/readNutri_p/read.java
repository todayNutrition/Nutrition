package readNutri_p;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import etc_p.FFFPath;
import etc_p.FileHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReadNutriService;

public class read implements ReadNutriService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			String upLoadFile = new FileHandler(request).uploadFile(request.getPart("nuImg"));
			System.out.println(upLoadFile);
			
			String path = "\\ppy\\ReadNu.py";
			//path = "E:\\YYJ\\study\\Nutrition\\src\\main\\webapp\\ppy\\ReadNu.py";
			path = request.getServletContext().getRealPath("ppy/ReadNu.py");
			
			
			String pp = (upLoadFile.substring(upLoadFile.lastIndexOf(".")+1)).toUpperCase();
			System.out.println(pp);
			
			String info = "";
			if(pp.equals("JPG")||pp.equals("PNG")||pp.equals("JPEG")||pp.equals("BMP")) {
				String pyPh =  new FFFPath(request).directory+upLoadFile;
				
				//System.out.println(pyPh);
				ProcessBuilder pb = new ProcessBuilder("python",path,pyPh);
				
				Process process = pb.start();
				// 실행중에 print()로 출력하는 내용 가져오기
				InputStreamReader isr = new InputStreamReader(process.getInputStream(),"ms949");
				BufferedReader br = new BufferedReader(isr);
				
				response.setContentType("text/html; charset=UTF-8");
				
				String line = null;
				
				boolean chk = true;
				while((line=br.readLine())!=null) {
					System.out.println("pythonf 출력 : "+line);
					if(line.equals("err")) {
						chk = false;
						System.out.println("에러");
						info="err";
						break;
					}else if(line.equals("ValueErr")){
						chk = false;
						System.out.println("데이터값에러");
						info="ValueErr";
						break;
					}else{
						info += line+"/";
					}
				}
				
				br.close();
				isr.close();
				
				
				if(chk) {
					info += upLoadFile;
				}
				System.out.println(info);

				int exitCode = process.waitFor();
				System.out.println("종료 코드 : "+ exitCode);
				response.getWriter().append(info);
			}else {
				info="FileErr";
				response.getWriter().append(info);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
