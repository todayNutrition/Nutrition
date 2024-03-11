package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class StartReg implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("웅 입력을 시작해보께~");
		// 시작페이지 기초 입력 정보
		MainDTO dto = new MainDTO();
		dto.setName(request.getParameter("name"));
		dto.setHeight(request.getParameter("height"));
		dto.setWeight(request.getParameter("weight"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setGender(request.getParameter("gender"));
		
		new MainDAO().userWrite(dto);
		System.out.println("요우요ㅛ");
		request.setAttribute("mainUrl", "/view/main/Main.jsp");
	}
}
