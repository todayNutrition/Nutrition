package myGoal_p;

import java.util.ArrayList;

import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dao_p.RecommendNutriDAO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalDetail implements MyGoalService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MainDTO mdto = new MainDAO().detail();
		NutritionDTO ndto = new NutritionDAO().todayNutrition();
		NutritionDTO total = new NutritionDAO().totalNutrition();
		
		request.setAttribute("total", total);
		request.setAttribute("mdata", mdto);
		request.setAttribute("ndata", ndto);
		
		ArrayList<RecommendNutriDTO> dto = new RecommendNutriDAO().list(mdto.getAge(),mdto.getGender());
		request.setAttribute("data", dto);
		}
	
	
}
