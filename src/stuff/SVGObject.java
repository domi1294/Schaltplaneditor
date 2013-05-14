package stuff;

public abstract class SVGObject implements Drawable {

	@Override
	public void add(Drawable d) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(Drawable d) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Drawable getChild(int index) {
		throw new UnsupportedOperationException();
	}

}
