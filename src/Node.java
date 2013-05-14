import java.awt.Graphics;
import java.util.ArrayList;


public class Node implements Drawable {

	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	@Override
	public void draw(Graphics g) {
		for (Drawable d : drawables)
			d.draw(g);
	}

	@Override
	public void add(Drawable d) {
		drawables.add(d);
	}

	@Override
	public void remove(Drawable d) {
		drawables.remove(d);
	}

	@Override
	public Drawable getChild(int index) {
		return drawables.get(index);
	}


}
