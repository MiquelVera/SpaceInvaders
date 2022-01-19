package logic;

public abstract class Weapon extends GameObject {

	protected int damage;
	
	public Weapon(Game game, int x, int y, int live, int damage) {
		super(game, x, y, live);
		this.damage = damage;
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public void onDelete() {

	}

	@Override
	public abstract void move();

	@Override
	public abstract String toString();
	
	public void reset() {
		
	}

}
