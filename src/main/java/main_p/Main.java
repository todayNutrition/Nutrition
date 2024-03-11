package main_p;


import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class Main implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("메인띠");

		// 메인 페이지 저장된 기초정보
		MainDTO dto = new MainDTO();		
		MainDTO user = new MainDAO().userRead(dto);
		request.setAttribute("MainUser", user);
		
		// 메인페이지 하루 섭취량 데이터 정보(사진 자료)
	}
}
