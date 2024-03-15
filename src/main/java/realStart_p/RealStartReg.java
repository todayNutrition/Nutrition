package realStart_p;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dto_p.MainDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.RealStartService;


public class RealStartReg implements RealStartService{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	
    	// 로그인 이름으로 확인
    	String name = request.getParameter("name");
    	MainDTO res = new MainDAO().nameChk(name);
    	
    	// 사용자 정보가 존재하는 경우 메인 페이지로 이동
        if (res != null) {
    		request.setAttribute("msg", "영양해를 시작합니다.");
    		request.setAttribute("move", "/Nutrition/main/Main?name="+name);
    		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
    		request.setAttribute("MainUser", res);
    		
    		// 로그인 정보 변경 유지
    		request.getSession().setAttribute("UserSS",res);
    		// 로그인 유지
    		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
    		
    	// 사용자 정보가 없는 경우 기초 정보 입력 페이지로 이동	
        } else {
            request.setAttribute("mainUrl", "/view/main/Start.jsp");

        }
	}
}