package graph_p;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dao_p.RecommendNutriDAO;
import dto_p.CalendarDTO;
import dto_p.MainDTO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.GraphService;

public class Graph implements GraphService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("하이 난 그래프~");
		
		// 연령과 성별을 확인해 평균 권장 섭취량 데이터 가져오기
		MainDTO dto = new MainDAO().detail();
		ArrayList<RecommendNutriDTO> userData =  new RecommendNutriDAO().list1(dto.getKind(), dto.getGender());
		request.setAttribute("readUser", userData);
		
		
		// 오늘 섭취량 데이터 가져오기
		Date da = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		// 전체 DB가 오기 때문에 오늘날짜일 때 자료만 불러오게 조건 걸자
		ArrayList<CalendarDTO> dayData = new CalendarDAO().list();
		CalendarDTO ddd = new CalendarDTO();
		for (CalendarDTO ddt : dayData) {
			if(ddt.getRegDateStr().equals(day.format(da))) {
				ddd = ddt;
			}
		}
//		System.out.println(dayData);
		request.setAttribute("readDay", ddd);
	}

}
