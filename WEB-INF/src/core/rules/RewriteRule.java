package core.rules;

import java.util.regex.Pattern;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IRewriteRule;

public class RewriteRule implements IRewriteRule {

	private String regex;
	private String classname;

	public RewriteRule(String _regex, String _classname, String[] substitutions) {
		regex = _regex;
		classname = _classname;
	}

	// If the regex matches
	@Override
	public boolean matches(IContext context) {
		return Pattern.matches(regex, context._getRequest().getRequestURI());
	}

	// Rewrite the context to set the Action Class
	@Override
	public void rewrite(IContext context) {
		context.setActionClass(classname);

	}

}