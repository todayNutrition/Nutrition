package myGoal_p;

import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dao_p.RecommendNutriDAO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalModify implements MyGoalService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MainDTO dto = new MainDTO();
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		if(!request.getParameter("kcal").equals("")) {
			dto.setGoalKcal(Integer.parseInt(request.getParameter("kcal")));					
			new NutritionDAO().dayAvg(Integer.parseInt(request.getParameter("dayAvg")),ss.getName());
			new MainDAO().modify(dto,ss.getName());			
			request.setAttribute("msg", "목표칼로리가 수정되었습니다");
			request.setAttribute("move", "MyGoalDetail");
			request.setAttribute("mainUrl", "inc/moveUrl.jsp");
			
		}else {
			request.setAttribute("msg", "목표칼로리를 입력해주세요");
			request.setAttribute("move", "MyGoalDetail");
			request.setAttribute("mainUrl", "inc/moveUrl.jsp");
		}
		
	}

}
