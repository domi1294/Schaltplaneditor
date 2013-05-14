import java.awt.Graphics;


public interface Drawable {
	public void draw(Graphics g);
	public void add(Drawable d);
	public void remove(Drawable d);
	public Drawable getChild(int index);
}
