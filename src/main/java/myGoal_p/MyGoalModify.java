package myGoal_p;

import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalModify implements MyGoalService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		MainDTO mdto = new MainDAO().detail();
		
		dto.setKcal(Integer.parseInt(request.getParameter("kcal")));		
		
		new NutritionDAO().dayAvg(Integer.parseInt(request.getParameter("dayAvg")), mdto.getName());
		
		
		request.setAttribute("msg", "목표칼로리가 수정되었습니다");
		request.setAttribute("move", "MyGoalDetail");
		request.setAttribute("mainUrl", "inc/moveUrl.jsp");
		
	}

}
