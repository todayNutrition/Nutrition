package etc_p;

import jakarta.servlet.http.HttpServletRequest;

public class FFFPath {
	public FFFPath(HttpServletRequest request) {
		directory = request.getServletContext().getRealPath("fff/");
		//directory = "E:\\YYJ\\study\\Nutrition\\src\\main\\webapp\\fff\\";
	}
	public String directory;
}
