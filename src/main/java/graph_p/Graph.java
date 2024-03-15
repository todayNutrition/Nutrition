package graph_p;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dao_p.RecommendNutriDAO;
import dto_p.CalendarDTO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.GraphService;

public class Graph implements GraphService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 로그인 유지
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		
		// 연령과 성별을 확인해 평균 권장 섭취량 데이터 가져오기위한 녀석
		MainDTO dto = new MainDAO().detail(ss.getName());

		// 평균 가져오기
		NutritionDTO ndto = new NutritionDAO().todayGraph(dto.getKind(), dto.getGender(),dto.getName());
		request.setAttribute("readDay", ndto);

	}

}
