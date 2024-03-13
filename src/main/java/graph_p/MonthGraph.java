package graph_p;


import java.util.ArrayList;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dao_p.RecommendNutriDAO;
import dto_p.CalendarDTO;
import dto_p.MainDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.GraphService;

public class MonthGraph implements GraphService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 연령과 성별을 확인해 평균 권장 섭취량 데이터 가져오기
		MainDTO dto = new MainDAO().detail();
		ArrayList<RecommendNutriDTO> userData =  new RecommendNutriDAO().list1(dto.getKind(), dto.getGender());
		request.setAttribute("readUser", userData);
		System.out.println(dto.getKind());
		
		// 한 달 평균 섭취량 데이터 가져오기
		ArrayList<CalendarDTO> monthData = new CalendarDAO().monthlist();
		request.setAttribute("readMonth", monthData);

	}

}
