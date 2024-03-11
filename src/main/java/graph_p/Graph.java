package graph_p;


import dao_p.RecommendNutriDAO;
import dto_p.RecommendNutriDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.GraphService;

public class Graph implements GraphService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("하이 난 그래프~");
		// 연령과 성별을 확인해 평균 권장 섭취량 데이터 가져오기
//		 RecommendNutriDTO dto = new RecommendNutriDTO();		 
//		 RecommendNutriDTO user = new RecommendNutriDAO().recommendNutrition(dto.getKind(), dto.getGender());
//		 request.setAttribute("redUser", user);
		 
		 
		 // 메인 페이지 저장된 기초정보
		 
	}

}
