package module.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("Index")

public class Index extends HttpServlet{
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1){
		try {
			arg1.getWriter().println("<html><body>"
					+"<h1>Liste des actions que vous pouvez réaliser : </h1>"
					+"<ul>"
					+"<li>"
					+"<a href='InsertUser'>Insérer un utilisateur</a>"
					+"</li>"
					+"<li>"
					+"<a href='UpdateUser'>Mettre à jour un utilisateur</a>"
					+"</li>"
					+"</ul>"
					+"</body></html>");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
