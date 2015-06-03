package core.renderer;

import org.esgi.web.framework.context.interfaces.IContext;
import org.esgi.web.framework.renderer.interfaces.IRenderer;

public class Renderer implements IRenderer{

	public Renderer(){
	}
	
	@Override
	public String render(IContext context){
		// TODO Auto-generated method stub
		HTMLRenderer HTMLRender = null;
		return HTMLRender.render(context);
	}

}
