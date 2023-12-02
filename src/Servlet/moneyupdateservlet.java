package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconn.dbconn;

/**
 * Servlet implementation class moneyupdateservlet
 */
@WebServlet("/moneyupdateservlet")
public class moneyupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Connection con;
    public moneyupdateservlet() {
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
		String user=request.getParameter("user");
		String upi=request.getParameter("upi");
		String money=request.getParameter("money");
		String quantity=request.getParameter("quantity");
		String time=request.getParameter("time");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String section=request.getParameter("section");
		String description=request.getParameter("description");
		
		/*int i=Integer.parseInt(quantity);
		if(user.equals("new")){*/
		
		/*String date=request.getParameter("time");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");*/
		
		
		try
		{
			 con=dbconn.create();
			 PreparedStatement ps=con.prepareStatement("INSERT INTO findingcriminals.polaquist VALUES(id,?,?,?,?,?,?,?,?,?,?,?,?)");
			 ps.setString(1,time);
			 ps.setString(2,name);
			 ps.setString(3,mail);
			 ps.setString(4, upi);
			 ps.setString(5, money);
			 ps.setString(6, "");
			 ps.setString(7, "Request");
			 ps.setString(8,"");
			 ps.setString(9,quantity);
			 ps.setString(10,user);
			 ps.setString(11,section);
			 ps.setString(12,description);
			 int dd=ps.executeUpdate();	
			 if(dd==1){
				 response.sendRedirect("staffmain.jsp");
			 }else{
				 response.sendRedirect("moneyupdate.jsp");
			 }
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
	/*	
		Connection con;
	       
	    try{  
	       con=dbconn.create();
	       PreparedStatement ps=con.prepareStatement("SELECT * FROM pharmacymedical.money where  upi='"+upi+"' ");
	       
	       ResultSet rs=ps.executeQuery();
	       
	       while(rs.next())
	       {
	    
	    	   int cout=rs.getInt(10);  
	    	     int a=cout+i;
	    	     
	    	     String s=String.valueOf(a);
	    	     
		Statement st=con.createStatement();
		st.executeUpdate("UPDATE `pharmacymedical`.money set amount='"+money+"',quantity='"+s+"' where upi='"+upi+"' ");
		System.out.println("Success");
	response.sendRedirect("staffmain.jsp");
	}
		
		
	}catch(Exception e){
		System.out.println(e);
	}

	}*/
	}

}