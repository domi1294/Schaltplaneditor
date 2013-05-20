package geometries;

import java.awt.Graphics;
import java.util.List;

public class GraphicalNode extends GraphicalComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<GraphicalComponent> children;
	
	@Override
	public void attachChild(GraphicalComponent child) {
		children.add(child);
	}
	
	@Override
	public void detachChild(GraphicalComponent child) {
		children.remove(child);
	}
	
	@Override
	public GraphicalComponent getChild(int i) {
		return children.get(i);
	}
	
	@Override
	public void draw(Graphics g) {
		for (GraphicalComponent gc : children)
			gc.draw(g);
	}

}
