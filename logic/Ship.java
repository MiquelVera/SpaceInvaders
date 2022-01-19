package logic;

public abstract class Ship extends GameObject {

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	@Override
	public abstract void computerAction();

	@Override
	public abstract void onDelete();

	@Override
	public abstract void move();
	
	@Override
	public abstract String toString();
	
	public abstract void reset();
}
