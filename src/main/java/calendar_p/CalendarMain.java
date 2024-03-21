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
			hm1.put("kcal", dto.getKcal());
			hm1.put("carbo", dto.getCarbo());
			hm1.put("na", dto.getNa());
			hm1.put("sugar", dto.getSugar());
			hm1.put("protein", dto.getProtein());
			hm1.put("chole", dto.getChole());
			hm1.put("fat", dto.getFat());
			hm1.put("sfat", dto.getsFat());
			hm1.put("tfat", dto.gettFat());
			hm1.put("sortIdx", 0);
			events.add(hm1);
			
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
