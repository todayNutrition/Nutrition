package readNutri_p;

import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ReadNutriService;


public class ReadNutriReg implements ReadNutriService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			NutritionDTO dto = new NutritionDTO();
			MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
			MainDTO mdto = new MainDAO().detail(ss.getName());
			
			dto.setNa(Integer.parseInt(request.getParameter("na")));
			dto.setCarbo(Integer.parseInt(request.getParameter("carbo")));
			dto.setSugar(Integer.parseInt(request.getParameter("sugar")));
			dto.setFat(Integer.parseInt(request.getParameter("fat")));
			dto.settFat(Integer.parseInt(request.getParameter("tFat")));
			dto.setsFat(Integer.parseInt(request.getParameter("sFat")));
			dto.setChole(Integer.parseInt(request.getParameter("chole")));
			dto.setProtein(Integer.parseInt(request.getParameter("protein")));
			dto.setKcal(Integer.parseInt(request.getParameter("kcal")));
			dto.setName(mdto.getName());

			new NutritionDAO().write(dto);
			
			request.setAttribute("mainUrl", "inc/moveUrl.jsp");
			request.setAttribute("msg","성분표가 등록되었습니다.");
			request.setAttribute("move", "/Nutrition/readNutri/ReadNutri");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
