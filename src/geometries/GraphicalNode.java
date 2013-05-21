package geometries;

import java.awt.Graphics;
import java.util.List;

public class GraphicalNode extends SVGComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<SVGComponent> children;
	
	@Override
	public void attachChild(SVGComponent child) {
		children.add(child);
	}
	
	@Override
	public void detachChild(SVGComponent child) {
		children.remove(child);
	}
	
	@Override
	public SVGComponent getChild(int i) {
		return children.get(i);
	}
	
	@Override
	public void draw(Graphics g) {
		for (SVGComponent gc : children)
			gc.draw(g);
	}

}
