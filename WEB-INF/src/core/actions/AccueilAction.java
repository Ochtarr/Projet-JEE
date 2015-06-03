package core.actions;

import org.esgi.web.framework.action.interfaces.IActionRenderable;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import core.renderer.Renderer;

public class AccueilAction implements IActionRenderable{
	
	public Renderer renderer;
	public int priority;
	public String[] role;

	@Override
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		this.priority = priority;
		return priority;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return this.priority;
	}

	@Override
	public void addCredential(String role) {
		// TODO Auto-generated method stub
		String[] tmp = new String[this.role.length+1];
		for(int i=0; i<role.length(); i++)
			tmp[i] = this.role[i];
		tmp[this.role.length+1]=role;
		this.role = tmp;
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
		
	}

	@Override
	public void setRenderer(IRenderer renderer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String render() {
		// TODO Auto-generated method stub
		String s = "";
		
		
		
		return null;
	}
	
	private String createConnectionForm(){
		String s = "";
		s+="<FORM ACTION='http://127.0.0.1:8080/MyJavaFramework/User/LogIn/' METHOD='GET'>";
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
						s+="Password : ";
					s+="</TD>";
					s+="<TD>";
						s+="<INPUT TYPE='hidden' NAME='password' />";
					s+="</TD>";
				s+="</TR>";
				s+="<TR>";
					s+="<TD>";
					s+="</TD>";
					s+="<TD>";
						s+="<INPUT TYPE='submit' name='connect' value='Sign Up' />";
					s+="</TD>";
				s+="</TR>";
			s+="</TABLE>";
		s+="</FORM>";
		return s;
	}
	
	private String createInscriptionForm(){
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
