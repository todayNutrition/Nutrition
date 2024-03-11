package myGoal_p;

import dao_p.MainDAO;
import dao_p.RecommendNutriDAO;
import dto_p.MainDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

public class MyGoalModify implements MyGoalService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		RecommendNutriDTO dto = new RecommendNutriDTO();
		MainDTO mdto = new MainDAO().detail();
		dto.setKcal(Integer.parseInt(request.getParameter("kcal")));
		
		new RecommendNutriDAO().modify(dto,mdto.getAge(),mdto.getGender());
		request.setAttribute("move", "MyGoalDetail");
		request.setAttribute("mainUrl", "moveUrl.jsp");
		
	}

}