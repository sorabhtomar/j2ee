package pages;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
@WebServlet("/hi")
public class  HelloServlet extends HttpServlet
{
	//init
	public void init() throws ServletException
	{
		 System.out.println("in init "+Thread.currentThread());
	}
	//destroy
	public void destroy() 
	{
		 System.out.println("in destroy "+Thread.currentThread());
	}
	//do get
	public void doGet(HttpServletRequest rq,HttpServletResponse rs) throws ServletException,IOException
	{
		System.out.println("in do-get "+Thread.currentThread());
		//set cont type
		rs.setContentType("text/html");
		//PW & send resp
		try(PrintWriter pw=rs.getWriter())
		{
			pw.print("<h3> Welcome 2 Servlets @"+new Date()+" </h3>");
		}
	}
}
