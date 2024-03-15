package main_p;

import java.util.regex.Pattern;

import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class StartReg implements MainService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MainDTO dto = new MainDTO();
		String hh = request.getParameter("height");
		String ww = request.getParameter("weight");
		// 시작페이지 기초 입력 정보		
		if(request.getParameter("name").equals("") ||
			request.getParameter("height").equals("") ||
			request.getParameter("weight").equals("") ||
			request.getParameter("age").equals("") ||
			request.getParameter("gender") == null) {
			
			request.setAttribute("msg", "다시 입력해주세요.");
			request.setAttribute("move", "/Nutrition/realStart/RealStartReg?name="+request.getParameter("name"));
			request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
		
		}else {
			dto.setName(request.getParameter("name"));
			dto.setHeight(Double.parseDouble(request.getParameter("height")));
			dto.setWeight(Double.parseDouble(request.getParameter("weight")));
			dto.setAge(Integer.parseInt(request.getParameter("age")));
			dto.setGender(request.getParameter("gender"));
			MainDTO res = new MainDAO().userRead(dto);
			
			// 시작페이지 기초 입력 정보 입력	
			new MainDAO().userWrite(dto, dto.getKind());
			request.setAttribute("msg", "영양해를 시작합니다.");
			request.setAttribute("move", "/Nutrition/main/Main?name="+dto.getName());
			request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
			
			// 로그인 정보 변경 유지
			request.getSession().setAttribute("UserSS", dto); 
			
		}
	}
}
