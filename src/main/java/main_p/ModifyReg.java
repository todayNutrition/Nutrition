package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class ModifyReg implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// 메인페이지 기초 입력 정보 수정
		MainDTO dto = new MainDTO();
		dto.setHeight(Double.parseDouble(request.getParameter("height")));
		dto.setWeight(Double.parseDouble(request.getParameter("weight")));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setGender(request.getParameter("gender"));

		// 로그인 유지
		MainDTO ss = (MainDTO) request.getSession().getAttribute("UserSS");

		System.out.println(ss.getName());
		// 메인 페이지 저장된 기초정보
		MainDTO user = new MainDAO().nameChk(ss.getName());
		request.setAttribute("MainUser", user);

		
		// 메인 페이지 저장된 기초정보 수정
		new MainDAO().userModify(dto, dto.getKind(), ss.getName());
		request.setAttribute("msg", "수정이 완료되었습니다.");
		request.setAttribute("move", "/Nutrition/main/Main?name=" + ss.getName());
		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
		
		// 로그인 정보 변경 유지
		request.getSession().setAttribute("UserSS", user);

	}
}
