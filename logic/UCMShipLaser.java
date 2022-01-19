package logic;

public class UCMShipLaser extends Weapon{
	
	private Game game;
	
	public static final String list = "oo: UCMShipLaser";
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, 1, 1);
		this.damage = 1;
		this.game = game;
	}

	public boolean objectAt(int i, int j) {
		boolean b = false;
		if(this.x == i && this.y == j) {
			b = true;
		}
		return b;
	}

	public String toString() {
		if(this.isAlive()) {
			return "oo";
		}
		else {
			return "";
		}
	}

	
	public boolean performAttack(GameObject other) {
		if(other.getX() == this.x && other.getY() == this.y) {
			if(other.receiveMissileAttack(this.damage)) {
				this.live = 0;
				game.setShootIsPossible(true);
				return true;
			}
		}
		return false;
	};
	//public boolean receiveMissileAttack(int damage) {return false;};
	public boolean receiveBombAttack(int damage) {
		this.live -= damage;
		game.setShootIsPossible(true);
		return true;
	}

	//public boolean receiveShockWaveAttack(int damage) {return false;};
	
	public boolean receiveExplosionAttack(int damage){
		this.live -= damage;
		game.setShootIsPossible(true);
		return true;
	}
	
	@Override
	public void move() {
		if(this.x - 1 >= 0) {
			this.x--;
		}
		else {
			this.live = 0;
			game.setShootIsPossible(true);
		}
	}

	@Override
	public String stringify() {
		String s = "M;" + this.x + "," + this.y;
		return s;
	};
}
