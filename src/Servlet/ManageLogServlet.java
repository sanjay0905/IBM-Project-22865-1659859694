package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageLogServlet
 */
@WebServlet("/ManageLogServlet")
public class ManageLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageLogServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String uname=request.getParameter("mail");
		System.out.println("Username "+uname);
		String pass=request.getParameter("password");
		System.out.println("password "+pass);
			
		
		if(uname.equals("admin@gmail.com") && pass.equals("admin")) {
				
			response.sendRedirect("managementhome.jsp");
			
		}
		
	else{
		response.sendRedirect("manageloginerror.jsp");
	}
		
	}

}
