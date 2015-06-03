package core.controller;

import java.io.IOException;

import org.esgi.web.framework.action.interfaces.IAction;
import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IDispatcher;

public class Dispatcher implements IDispatcher {

	@Override
	// Instanciate the Action Class then proceed with the context
	public void dispatch(IContext context) {
		String className = context.getActionClass();

		try {
			IAction actionClass = (IAction) Class.forName(className)
					.newInstance();
			//If a class exists for the context -> proceed
			if (actionClass != null)
				actionClass.proceed(context);
		} catch (
				/*InstantiationException | IllegalAccessException
				| ClassNotFoundException | NullPointerException*/
				Exception e) {
			try {
				context._getResponse().setContentType("text/html");
				context._getResponse().getOutputStream()
						.println("<html><head></head><body>");
				context._getResponse().getOutputStream()
						.println("<h1>No Regex recognized !</h1>");
				context._getResponse().getOutputStream().println("</body>");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

}