package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class StartReg implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 시작페이지 기초 입력 정보		
		MainDTO dto = new MainDTO();
		dto.setName(request.getParameter("name"));
		dto.setHeight(request.getParameter("height"));
		dto.setWeight(request.getParameter("weight"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setGender(request.getParameter("gender"));
		
		// 시작페이지 기초 입력 정보 입력	
		new MainDAO().userWrite(dto, dto.getKind());
		request.setAttribute("msg", "영양해를 시작합니다.");
		request.setAttribute("move", "/Nutrition/main/Main?name="+dto.getName());
		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
		
		// 로그인 정보 변경 유지
		request.getSession().setAttribute("UserSS", dto); 

	}
}
