

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mess
 */
@WebServlet("/Mess")
public class Mess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession(false);
	    String fromMsg=(String)ses.getAttribute("myusername");
	    String ToMsg=request.getParameter("msguser");
	    String msg=request.getParameter("message");
	    PrintWriter pw=response.getWriter();
	    try
		   {
			   Class.forName("com.mysql.jdbc.Driver");  
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manohar","root","root");  
			   Statement stmt=con.createStatement(); 
			   String query="insert into Message values('"+fromMsg+"','"+ToMsg+"','"+ msg+"')";
			   int i=stmt.executeUpdate(query);
			   if(i>0)
			   {
				   pw.print("Registered");
				   response.sendRedirect("DisplayMsg.jsp");
			   }
			   con.close();
			   
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}    
	    
	}

}

	
