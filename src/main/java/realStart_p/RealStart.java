package realStart_p;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.RealStartService;

public class RealStart implements RealStartService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		request.getSession().invalidate();
		
		 request.setAttribute("mainUrl", "/view/realStart/RealStart.jsp");
	}
}
