package readNutri_p;

import etc_p.FileHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReadNutriService;

public class ReadNutriReg implements ReadNutriService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String upLoadFile = new FileHandler(request).uploadFile(request.getPart("nutriFile"));
			System.out.println(upLoadFile);
			
			request.setAttribute("mainUrl", "inc/alert.jsp");
			request.setAttribute("msg","성분표가 등록되었습니다.");
			request.setAttribute("goUrl", "/Nutrition/readNutri/ReadNutri");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
