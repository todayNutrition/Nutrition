package realStart_p;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.RealStartService;


public class RealStartReg implements RealStartService{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // 쿠키에서 사용자 정보를 가져옵니다. //조건 추가하기 : 사용자 정보가 null 이면 !!
        Cookie[] cookies = request.getCookies();
        String userInfo = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userInfo")) {
                    userInfo = cookie.getValue();
                    break;
                }
            }
        }

        if (userInfo != null) {
            // 사용자 정보가 존재하는 경우 메인 페이지로 이동합니다.
    		request.setAttribute("msg", "영양해를 시작합니다.");
    		request.setAttribute("move", "/Nutrition/main/Main");
    		request.setAttribute("mainUrl", "/view/inc/moveUrl.jsp");
        } else {
            // 사용자 정보가 없는 경우 기초 정보 입력 페이지로 이동합니다.
            request.setAttribute("mainUrl", "/view/main/Start.jsp");
            
            // 사용자 정보를 저장하는 쿠키를 생성합니다.
            Cookie userInfoCookie = new Cookie("userInfo", "someUserInfo");
            userInfoCookie.setMaxAge(60 * 60 * 24 * 30); // 쿠키의 유효기간을 설정합니다. (예: 한 달)
            response.addCookie(userInfoCookie);
        }

	}
}