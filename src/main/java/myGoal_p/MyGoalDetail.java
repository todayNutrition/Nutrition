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
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		MainDTO mdto = new MainDAO().detail(ss.getName());
		
		NutritionDTO ndto = new NutritionDAO().todayNutrition(mdto.getKind(), mdto.getGender(),ss.getName());
		NutritionDTO total = new NutritionDAO().totalNutrition(ss.getName());
		
		request.setAttribute("total", total);
		request.setAttribute("mdata", mdto);
		request.setAttribute("ndata", ndto);
		
		ArrayList<RecommendNutriDTO> dto = new RecommendNutriDAO().list(mdto.getAge(),mdto.getGender());
		request.setAttribute("data", dto);
		
		//view 에서 총점 보여주기 위한 계산
		int dayAvg = (int)((ndto.getKcal()+ndto.getCarbo()+ndto.getNa()+ndto.getSugar()+ndto.getProtein()+ndto.getChole()+ndto.getFat()+ndto.getsFat()+ndto.gettFat())/9);
		request.setAttribute("dayAvg", dayAvg);
		
		
		ndto = new NutritionDTO();
		new NutritionDAO().dayAvg(dayAvg, ss.getName());
		
		
		}
	
	
}
