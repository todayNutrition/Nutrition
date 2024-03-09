package controller_p;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.MyGoalService;

import java.io.IOException;

@WebServlet("/myGoal/*")
public class MyGoalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyGoalController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mainfolder = "myGoal/";
		String mainJsp = request.getRequestURI().substring((request.getContextPath()+"/"+mainfolder).length());
		request.setAttribute("mainUrl", mainfolder+mainJsp+".jsp");		
		try {
			MyGoalService ser = (MyGoalService)Class.forName("myGoal_p."+mainJsp).newInstance();
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
