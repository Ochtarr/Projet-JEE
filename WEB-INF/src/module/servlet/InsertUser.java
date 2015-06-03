package module.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertUser")

public class InsertUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest arg0, HttpServletResponse arg1){
		try {
			String s ="" ;
			s = InsertUserFormBuild(s);
			arg1.getWriter().println("<html><body>"+s+"</body></html>");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String InsertUserFormBuild(String s) {
		// TODO Auto-generated method stub
		if(s.isEmpty()==true){
			s+="<FORM ACTION='http://127.0.0.1:8080/MyJavaFramework/User/Insert/GET' METHOD='GET'>";
				s+="<TABLE>";
					s+="<TR>";
						s+="<TD>";
							s+="Login : ";
						s+="</TD>";
						s+="<TD>";
							s+="<INPUT TYPE='text' NAME='login' />";
						s+="</TD>";
					s+="</TR>";
					s+="<TR>";
						s+="<TD>";
							s+="Email : ";
						s+="</TD>";
						s+="<TD>";
						s+="<INPUT TYPE='text' NAME='email' />";
						s+="</TD>";
					s+="</TR>";
					s+="<TR>";
						s+="<TD>";
							s+="Password : ";
						s+="</TD>";
						s+="<TD>";
							s+="<INPUT TYPE='hidden' NAME='password' />";
						s+="</TD>";
					s+="</TR>";
					s+="<TR>";
						s+="<TD>";
							s+="Etes vous un administrateur ?";
						s+="</TD>";
						s+="<TD>";
							s+="<INPUT TYPE='radio' name='isAdmin' value='OUI' />";
							s+="<INPUT TYPE='radio' name='isAdmin' value='NON' />";
						s+="</TD>";
					s+="</TR>";
				s+="</TABLE>";
			s+="</FORM>";
			return s;
		}
		else
			return "";
	}
}
