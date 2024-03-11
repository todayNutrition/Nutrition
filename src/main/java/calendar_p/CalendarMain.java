package calendar_p;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import dao_p.CalendarDAO;
import dto_p.CalendarDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CalendarService;


public class CalendarMain implements CalendarService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<CalendarDTO> calDto = new CalendarDAO().list();
		ArrayList<HashMap> events = new ArrayList<HashMap>();
		System.out.println(calDto);
		for (CalendarDTO dto : calDto) {
			HashMap hm1 = new HashMap();
			hm1.put("title", "칼로리 "+dto.getKcal()+"kcal");
			hm1.put("start", dto.getRegDateStr());
			hm1.put("allDay", true);
			hm1.put("backgroundColor", "pink");
			hm1.put("textColor", "white");
			hm1.put("sortIdx", 0);
			events.add(hm1);
			
			HashMap hm2 = new HashMap();
			hm2.put("title", "탄수화물 "+dto.getCarbo()+"g");
			hm2.put("start", dto.getRegDateStr());
			hm2.put("allDay", true);
			hm2.put("backgroundColor", "blue");
			hm2.put("textColor", "white");
			hm2.put("sortIdx", 0);
			events.add(hm2);
			
			HashMap hm3 = new HashMap();
			hm3.put("title", "단백질 "+dto.getProtein()+"g");
			hm3.put("start", dto.getRegDateStr());
			hm3.put("allDay", true);
			hm3.put("backgroundColor", "green");
			hm3.put("textColor", "white");
			hm3.put("sortIdx", 3);
			events.add(hm3);
			
			HashMap hm4 = new HashMap();
			hm4.put("title", "칼로리 "+dto.getFat()+"g");
			hm4.put("start", dto.getRegDateStr());
			hm4.put("allDay", true);
			hm4.put("backgroundColor", "red");
			hm4.put("textColor", "white");
			hm4.put("sortIdx", 4);
			events.add(hm4);
			
		}
		request.setAttribute("events", events);
		System.out.println("CalendarMain.execute() 실행 : ");
		
	}
	
}