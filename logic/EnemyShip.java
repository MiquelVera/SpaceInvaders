package logic;

public abstract class EnemyShip extends Ship {

	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract void reset();

	
}
