package core.actions;

import java.io.IOException;

import model.user.User;
import model.user.UserCollection;

import org.esgi.web.framework.action.interfaces.IActionRenderable;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import core.controller.Context;
import core.renderer.Renderer;

public class InsertUserAction implements IActionRenderable{

	public Renderer render;
	public int priority;
	public String[] roles;
	public UserCollection listUsers;

	@Override
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addCredential(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean needsCredentials() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCredential(String[] roles) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void proceed(IContext context) {
		// TODO Auto-generated method stub

		//Récupération des données
		String pseudo = ((Context) context).getParameterUnique("pseudo");
		String password = ((Context) context).getParameterUnique("password");
		String email = ((Context) context).getParameterUnique("email");
		String[] droits = (String[]) ((Context) context).getParameter("roles");

		if(listUsers==null)
			listUsers = UserCollection.getInstance();

		User u = new User(UserCollection.nbUser+1, pseudo, password, email, droits );
		UserCollection.getInstance().addUser(u);

		try {
			context._getResponse().getWriter().print("<HTML><BODY>Utilisateur ajouté : "+ pseudo +"<BR /></BODY></HTML>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setRenderer(IRenderer renderer) {
		// TODO Auto-generated method stub
		this.render = (Renderer) renderer;
	}

	@Override
	public String render() {
		// TODO Auto-generated method stub
		String s = "";

		return s;
	}

	private String createInsertForm(){
		String s = "";
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

}
