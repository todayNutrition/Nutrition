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
			
			
			//String [] nm = request.getParameter("nm").split("\\\\");
			//String pp = nm[2];
			//System.out.println(pp);
			
			
			String pyPh =  new FFFPath(request).directory+upLoadFile;
			
			System.out.println(pyPh);
			ProcessBuilder pb = new ProcessBuilder("python",path,pyPh);
			
			Process process = pb.start();
			// 실행중에 print()로 출력하는 내용 가져오기
			InputStreamReader isr = new InputStreamReader(process.getInputStream(),"ms949");
			BufferedReader br = new BufferedReader(isr);
			
			String info = "";
			String line = null;
			while((line=br.readLine())!=null) {
				//System.out.println("pythonf 출력 : "+line);
				info += line+".";
			}
			info += upLoadFile;
			br.close();
			isr.close();
			System.out.println(info);

			int exitCode = process.waitFor();
			System.out.println("종료 코드 : "+ exitCode);
			
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append(info);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
