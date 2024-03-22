package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class ModifyName implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 메인페이지 기초 입력 정보 수정
		MainDTO dto = new MainDTO();
		dto.setName(request.getParameter("name"));

		// 로그인 유지
		MainDTO ss = (MainDTO) request.getSession().getAttribute("UserSS");

		MainDTO user = new MainDAO().nameChk(dto.getName());



		if(user!=null && dto.getName().equals(user.getName())) {
			// null이 아니고, DB와 입력 name이 같을 경우 수정 불가
			request.setAttribute("msg", "이미 존재하는 닉네임입니다."); 
			request.setAttribute("move", "/Nutrition/main/Main?name="+ss.getName()); 
			request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
			
		}else {
			// 중복이 아닐 경우 닉네임 수정
			new MainDAO().userNameModify(dto.getName(), ss.getName());
			request.setAttribute("msg", "수정이 완료되었습니다.");
			request.setAttribute("move", "/Nutrition/main/Main?name=" + dto.getName());
			request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
			
			// 로그인 정보 변경 유지
			request.getSession().setAttribute("UserSS", dto);
		}
	}
}