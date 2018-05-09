

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

/**
 * Servlet implementation class Manohar
 */
@WebServlet("/signup")
public class Manohar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manohar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//System.out.println("User: "+user+" Passwrd: "+pwd);
		//String button=request.getParameter("mybutton");
		PrintWriter pw=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("1");
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306//manohar","root","root");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manohar","root","root");
			//System.out.println("2");
		   Statement st=con.createStatement();
		 //  System.out.println("3");
		   //System.out.println("User: "+user+" Passwrd: "+pwd);
		  // if(button.equals("Signup"))
		   //{
		   String query="insert into army values('"+user+"','"+pwd+"')";
		   int i=st.executeUpdate(query);
		   
		   if(i>0)
		   {
			pw.println("Registered Successfully");
		   }
		   
		  // }
	     con.close();
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}    
		
		
	}

}
