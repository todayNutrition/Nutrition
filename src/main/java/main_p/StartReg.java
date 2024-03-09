package main_p;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class StartReg implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		MainDTO dto = new MainDTO();
		dto.setName(request.getParameter("name"));
		dto.setHeight(request.getParameter("name"));
		dto.setWeight(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("name")));
		dto.setGender(request.getParameter("name"));
		dto.setGoalKcal(Integer.parseInt(request.getParameter("name")));
		
		new MainDAO().userWrite(dto);
		
		request.setAttribute("mainUrl", "/view/main/Main.jsp");
	}
}
