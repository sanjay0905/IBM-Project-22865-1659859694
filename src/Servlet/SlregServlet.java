package Servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.sregbean;
import Bean.tlregbean;
import Imple.Imple;
import Inter.Inter;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class SlregServlet
 */
@WebServlet("/SlregServlet")
public class SlregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SlregServlet() {
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
		String filetype=null;
		Part part;
		FilePart filepart;
		long size=0;
		String filename=null;
		
		filename=request.getParameter("filename");
		System.out.println("filename:"+filename);
 
		MultipartParser mp = new MultipartParser(request, 999999999);
		 
		
		PrintWriter out=response.getWriter();
		
		ArrayList list=new ArrayList<>();
		
		 
		
		String path = getServletContext().getRealPath(" ");
		System.out.println(path);
		

		String editPath = path.substring(0, path.indexOf("."));
		System.out.println(editPath);
		
		String fullpath = editPath + "cricketteam\\WebContent\\Local\\";
		System.out.println(fullpath);
		
		while ((part = mp.readNextPart()) != null)
		{
			if (part.isFile()) {
				filepart = (FilePart) part;
				
				filetype = filepart.getContentType();

				 filename = filepart.getFileName();
				System.out.println(filename);

				fullpath = fullpath + filename;
				System.out.println(fullpath);
				
				File file = new File(fullpath);
				size = filepart.writeTo(file);
				
				BufferedReader br = new BufferedReader(new FileReader(file));
		
				
			}
			else if(part.isParam())
			{
				ParamPart param = (ParamPart) part;
				String name = param.getName();
				
				String value = param.getStringValue();

				System.out.println("Loadinggg...... " + value);
				list.add(value);					
			}				
		}
sregbean tr=new sregbean();
		
		
				
		
	 		 tr.setName((list.get(0).toString()));
		 	    System.out.println("Name :"+list.get(1).toString());
		 	    
		 	   tr.setEmail((list.get(1).toString()));
		 	    System.out.println("Email :"+list.get(2).toString());
		 	    
		 	   tr.setMobile((list.get(2).toString()));
		 	    System.out.println("Mobile :"+list.get(3).toString());
		 	    
		 	   tr.setTeam((list.get(3).toString()));
		 	    System.out.println("Password :"+list.get(4).toString());
		 	    
		 	   tr.setPassword((list.get(4).toString()));
		 	    System.out.println("Password :"+list.get(4).toString());
		 	    
		 	   tr.setCpassword((list.get(5).toString()));
		 	    System.out.println("Confirm Password :"+list.get(5).toString());
		 
		 	    
		 	   
	 	    
	 	   tr.setImage(filename);
		  
		

		
		
		Inter in=new Imple();
		int i=in.sreg(tr);
		if(i==1){
			response.sendRedirect("Stafflogin.jsp");
		}
		else{
			response.sendRedirect("error.jsp");
		}

		
	}

}
