package core.actions;

import org.esgi.web.framework.action.interfaces.IActionRenderable;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

import core.renderer.Renderer;

public class UpdateUserAction implements IActionRenderable{
	
	public Renderer updateFormRender;
	public int priority;
	public String[] role;
	
	public UpdateUserAction(){
		updateFormRender = new Renderer();
		priority = Integer.MAX_VALUE;
		role = null;
	}
	
	public UpdateUserAction(Renderer _updateFormRender, int _priority, String[] _role){
		updateFormRender = _updateFormRender;
		priority = _priority;
		role = _role;
	}

	@Override
	public int setPriority(int priority) {
		// TODO Auto-generated method stub
		this.priority = priority;
		return this.priority;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return this.priority;
	}

	@Override
	public void addCredential(String role) {
		// TODO Auto-generated method stub
		if(this.role==null){
			this.role= new String[1];
			this.role[0]=role;
		}
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
		s+="<FORM ACTION='' METHOD=''>";
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

