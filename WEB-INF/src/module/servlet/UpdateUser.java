package module.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUser")

public class UpdateUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest arg0, HttpServletResponse arg1){
		try {
			arg1.getWriter().println("<html><body><h1>Hello World Servlet</h1></body></html>");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
