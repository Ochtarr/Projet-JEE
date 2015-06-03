package core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.esgi.web.framework.core.interfaces.IFrontController;
import org.esgi.web.framework.router.interfaces.IDispatcher;
import org.esgi.web.framework.router.interfaces.IRewriter;

import core.rules.RewriteRule;

public class FrontController extends HttpServlet implements IFrontController {

	private IDispatcher dispatcher;
	private IRewriter rewriter;
	private Context c;
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		dispatcher = new Dispatcher();
		rewriter = new Rewriter();
		//New rule -- Pattern is /JavaWebFramework/User/LogIn -- Related ActionClass is LogInAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/LogIn",
				"core.actions.LogInAction",  new String[]{"user_id"}));
				
		//New rule -- Pattern is /JavaWebFramework/User/LogOut -- Related ActionClass is LogOutAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/LogOut",
				"core.actions.LogOutAction",  new String[]{"user_id"}));
		
		//New rule -- Pattern is /JavaWebFramework/User/Insert -- Related ActionClass is InsertUserAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/Insert",
				"core.actions.InsertUserAction",  new String[]{"user_id"}));
		
		//New rule -- Pattern is /JavaWebFramework/User/Update -- Related ActionClass is UpdateUserAction
		rewriter.addRule(new RewriteRule("/myJavaFramework/User/Update",
				"core.actions.UpdateUserAction", new String[]{"user_id"}));
	
		//New rule -- Pattern is /JavaWebFramework/User/Remove -- Related ActionClass is RemoveUserAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/Remove",
				"core.actions.RemoveUserAction",  new String[]{"user_id"}));
		
		//New rule -- Pattern is /JavaWebFramework/User/Display -- Related ActionClass is DisplayUserAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/Display",
				"core.actions.DisplayUserAction",  new String[]{"user_id"}));
		
		//New rule -- Pattern is /JavaWebFramework/User/Search -- Related ActionClass is SearchUserAction
		rewriter.addRule(new RewriteRule("/MyjavaFramework/User/Search",
				"core.actions.SearchUserAction",  new String[]{"user_id"}));
	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		handle(request, response);
	}

	public void handle(HttpServletRequest request, HttpServletResponse response) {
		//New Context
		try {
			c = new Context(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Rewrite the context first (if the regex matches, rewrite the context to set the ActionClass)
		rewriter.rewrite(c);
		//Dispatch the context to the appropriate ActionClass then proceed
		dispatcher.dispatch(c);
		
		try {
			response.getWriter().print("<HTML><BODY><H1>test</H1></BODY></HTML>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
