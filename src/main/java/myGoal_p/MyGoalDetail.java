package myGoal_p;

import java.util.ArrayList;

import dao_p.RecommendNutriDAO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalDetail implements MyGoalService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<RecommendNutriDTO> dto = new RecommendNutriDAO().list();
		request.setAttribute("data", dto);
	}
	
	
}
