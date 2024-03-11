package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class ModifyReg implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 메인페이지 기초 입력 정보 수정
		MainDTO dto = new MainDTO();
		dto.setName(request.getParameter("name"));
		dto.setHeight(request.getParameter("height"));
		dto.setWeight(request.getParameter("weight"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setGender(request.getParameter("gender"));
		
		new MainDAO().userModify(dto);
		request.setAttribute("msg", "수정이 완료되었습니다.");
		request.setAttribute("move", "/Nutrition/main/Main");
		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
	}
}