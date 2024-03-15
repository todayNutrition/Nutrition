package calendar_p;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao_p.CalendarDAO;
import dao_p.MainDAO;
import dao_p.NutritionDAO;
import dto_p.CalendarDTO;
import dto_p.MainDTO;
import dto_p.NutritionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CalendarService;


public class CalendarMain implements CalendarService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MainDTO ss = (MainDTO)request.getSession().getAttribute("UserSS");
		String name = ss.getName();
		MainDTO mdto = new MainDAO().detail(name);

	    NutritionDTO ndto = new NutritionDAO().todayNutrition(mdto.getKind(), mdto.getGender(),name);

	    int dayAvg = (int)((ndto.getKcal()+ndto.getCarbo()+ndto.getNa()+ndto.getSugar()+ndto.getProtein()+ndto.getChole()+ndto.getFat()+ndto.getsFat()+ndto.gettFat())/9);
	    
	    ndto = new NutritionDTO();
	    new NutritionDAO().dayAvg(dayAvg,name);
	    
		ArrayList<CalendarDTO> calDto = new CalendarDAO().list(name);
		ArrayList<HashMap> events = new ArrayList<HashMap>();
		for (CalendarDTO dto : calDto) {
			HashMap hm1 = new HashMap();
			hm1.put("title", dto.getDayavg()+"점");
			hm1.put("start", dto.getRegDateStr());
			hm1.put("backgroundColor", "white");
			hm1.put("allDay", true);
			hm1.put("textColor", "purple");
			hm1.put("description", dto.getDayavg());
			hm1.put("sortIdx", 0);
			events.add(hm1);
			
			HashMap hm2 = new HashMap();
			hm2.put("title", "칼로리 "+dto.getKcal()+"kcal");
			hm2.put("start", dto.getRegDateStr());
			hm2.put("allDay", true);
			hm2.put("backgroundColor", "pink");
			hm2.put("textColor", "white");
			hm2.put("description", dto.getDayavg());
			hm2.put("sortIdx", 1);
			events.add(hm2);
			
			HashMap hm3 = new HashMap();
			hm3.put("title", "탄수화물 "+dto.getCarbo()+"g");
			hm3.put("start", dto.getRegDateStr());
			hm3.put("allDay", true);
			hm3.put("backgroundColor", "rgba(54, 162, 235, 0.5)");
			hm3.put("textColor", "white");
			hm3.put("description", dto.getDayavg());
			hm3.put("sortIdx", 2);
			events.add(hm3);
			
			HashMap hm4 = new HashMap();
			hm4.put("title", "단백질 "+dto.getProtein()+"g");
			hm4.put("start", dto.getRegDateStr());
			hm4.put("allDay", true);
			hm4.put("backgroundColor", "rgba(153, 102, 255, 0.5)");
			hm4.put("textColor", "white");
			hm4.put("description", dto.getDayavg());
			hm4.put("sortIdx", 3);
			events.add(hm4);
			
			HashMap hm5 = new HashMap();
			hm5.put("title", "지방 "+dto.getFat()+"g");
			hm5.put("start", dto.getRegDateStr());
			hm5.put("allDay", true);
			hm5.put("backgroundColor", "rgba(75, 192, 192, 0.5)");
			hm5.put("textColor", "white");
			hm5.put("description", dto.getDayavg());
			hm5.put("sortIdx", 4);
			events.add(hm5);
		}
		
		JSONArray ja = new JSONArray();
        for (HashMap<String, Object> map : events) {
            JSONObject jsonObject = new JSONObject(map);
            ja.add(jsonObject);
        }
        
        String comments = "넌 망했어요,이게 맞아?,더 노력하세요,조금 아쉬워요,참 잘했어요,완벽해요";
        
        request.setAttribute("comments", comments);
        
        String jsonString = ja.toJSONString();
		request.setAttribute("events", jsonString);
		System.out.println("CalendarMain.execute() 실행 : ");
		
	}
	
}
