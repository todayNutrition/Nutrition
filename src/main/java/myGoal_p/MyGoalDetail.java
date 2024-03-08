package myGoal_p;

import dao_p.RecommendNutriDAO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalDetail implements MyGoalService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RecommendNutriDTO dto = new RecommendNutriDAO().recommendNutrition(request.getParameter("kind"),request.getParameter("gender"));
		
		request.setAttribute("data", dto);
	}
	
	
}
