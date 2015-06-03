package core.controller;

import java.util.ArrayList;
import java.util.List;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.router.interfaces.IRewriteRule;
import org.esgi.web.framework.router.interfaces.IRewriter;

public class Rewriter implements IRewriter {

	private List<IRewriteRule> rules;

	public Rewriter() {
		rules = new ArrayList<IRewriteRule>();
	}

	@Override
	public void addRule(IRewriteRule rule) {
		rules.add(rule);

	}
	
    /**
    * Loop on all rules - if a rule matches, rewrite the context with the rule's ActionClass
    *  @param context 
    * 	@Override
	*/
	public void rewrite(IContext context) {

		for (IRewriteRule r : rules) {
			if (r.matches(context)){
				r.rewrite(context);
				break;
			}
				
		}

	}

}