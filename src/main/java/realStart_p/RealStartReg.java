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


    	String name = request.getParameter("name");
    	MainDTO res = new MainDAO().nameChk(name);
    	System.out.println(res);
    	
        if (res != null) {
            // 사용자 정보가 존재하는 경우 메인 페이지로 이동
    		request.setAttribute("msg", "영양해를 시작합니다.");
    		request.setAttribute("move", "/Nutrition/main/Main?name="+name);
    		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
    		request.setAttribute("MainUser", res);
    		request.getSession().setAttribute("UserSS",res);
    		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
    		
        } else {
            // 사용자 정보가 없는 경우 기초 정보 입력 페이지로 이동
            request.setAttribute("mainUrl", "/view/main/Start.jsp");

        }
	}
}