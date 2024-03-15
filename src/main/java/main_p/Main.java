package main_p;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dto_p.CalendarDTO;
import dto_p.MainDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MainService;

public class Main implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 유지
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		
		// 메인 페이지 저장된 기초정보
		MainDTO user = new MainDAO().nameChk(ss.getName());
		request.setAttribute("MainUser", user);
		
		// 메인페이지 하루 섭취량 데이터 정보 
		Date da = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		// 전체 DB가 오기 때문에 오늘날짜일 때 자료만 불러오게 조건 걸자
		ArrayList<CalendarDTO> dayData = new CalendarDAO().list(ss.getName());
		CalendarDTO ddd = new CalendarDTO();
		for (CalendarDTO ddt : dayData) {
			if(ddt.getRegDateStr().equals(day.format(da))) {
				ddd = ddt;
			}
		}
		request.setAttribute("readDay", ddd);

	}

}
