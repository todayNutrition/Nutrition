package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.RealStartService;

import java.io.IOException;

@WebServlet("/realStart/*")
public class StartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String mainfolder = "realStart/";
		String mainJsp = request.getRequestURI().substring((request.getContextPath()+"/"+mainfolder).length());
		request.setAttribute("mainUrl", mainfolder+mainJsp+".jsp");
		
		try {
			RealStartService ser = (RealStartService)Class.forName("realStart_p."+mainJsp).newInstance();
			ser.execute(request, response); 
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("/view/template.jsp");
			dispatcher.forward(request, response);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
