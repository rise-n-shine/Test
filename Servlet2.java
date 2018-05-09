import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/login")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   String user=request.getParameter("uname");
	   String pas =request.getParameter("pwd");
	   PrintWriter pw=response.getWriter();
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver");  
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manohar","root","root");  
		   Statement stmt=con.createStatement();
		   System.out.println("username "+user+" "+"passwd "+pas);
		   ResultSet rs=stmt.executeQuery("select Uname from army where uname='"+user+"'and pwd='"+pas+"'");
		   if(rs.next())  
		   {
			pw.print("welcome"+rs.getString(1));
			HttpSession ses=request.getSession();
			ses.setAttribute("Uname",rs.getString(1));
			response.sendRedirect("Dashboard");
			}
		   else
		   {
			   pw.print("Invalid Login Details");
			   RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			   rd.include(request, response);
		   }
		   con.close();  
	   }
	   catch(Exception e)
	   {
		  e.printStackTrace();
	   }
	}
	
}
		   
		   
		   
		   
		   
		   
		   


