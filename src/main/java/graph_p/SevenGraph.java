package graph_p;


import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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

public class SevenGraph implements GraphService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 로그인 유지
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		
		// 연령과 성별을 확인해 평균 권장 섭취량 데이터 가져오기위한 녀석
		MainDTO dto = new MainDAO().detail(ss.getName());

		// 평균 가져오기
		NutritionDTO ndto = new NutritionDAO().todayGraph(dto.getKind(), dto.getGender(),dto.getName());
		request.setAttribute("readtoday", ndto);
		
		
		// 최근 7일 평균 데이터 가져오기
		ArrayList<NutritionDTO> wdto = new NutritionDAO().weekGraph(dto.getKind(), dto.getGender(),dto.getName());
		request.setAttribute("readWeek", wdto);
		for (NutritionDTO nn : wdto) {
			System.out.println(nn);
			
		}
		ArrayList size = new ArrayList();
		int sdfs = wdto.size();
		for (int i = 0; i < sdfs; i++) {
			size.add(100);
		}
		request.setAttribute("size", size);
		
	}

}
