package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.sregbean;

import Imple.Imple;
import Inter.Inter;

/**
 * Servlet implementation class SlLogServlet
 */
@WebServlet("/SlLogServlet")
public class SlLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlLogServlet() {
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
		
		
	
		
		String name=request.getParameter("mail");
		System.out.println("username: "+name);
		
		HttpSession sess=request.getSession();
		sess.setAttribute( "semail",name);
	
		
		String pass=request.getParameter("password");
		System.out.println("password: "+pass);
		
		
		
		
		sregbean ur=new sregbean();
		
		ur.setEmail(name);
		ur.setPassword(pass);
		
		
		Inter in=new Imple();
		boolean log=in.slog(ur);
		if(log==true){
			response.sendRedirect("staffmain.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}
		
	}
		
	}
	