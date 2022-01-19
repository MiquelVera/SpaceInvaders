package logic;

public class Bomb extends Weapon{
	private DestroyerShip destroyerShip;
	
	public static final String list = ". : Bomb";
	
	public Bomb(Game game, int x, int y, DestroyerShip destroyerShip) {
		super(game, x, y, 1, 1);
		this.x = x;
		this.y = y;
		this.game = game;
		this.destroyerShip = destroyerShip;
	}
	
	public boolean objectAt(int x, int y) {
		boolean b = false;
		if(this.x == x && this.y == y) {
			b = true;
		}
		return b;
	}
	
	public String toString() {
		String s = ".";
		return s;
	}
	
	
	public void bombErased() {//Bye bye bomb
		this.destroyerShip.readyToShoot();
	}
	
	public boolean performAttack(GameObject other) {
		if(other.getX() == this.x && other.getY() == this.y) {
			if(other.receiveBombAttack(this.damage)) {
				this.live = 0;
				this.destroyerShip.readyToShoot();
				return true;
			}
		}
		return false;
	};
	
	public boolean receiveMissileAttack(int damage) {
		this.live -= damage;
		this.destroyerShip.readyToShoot();
		return true;
	};
	
	//public boolean receiveBombAttack(int damage) {return false;};
	
	public boolean receiveShockWaveAttack(int damage) {
		this.live -= damage;
		this.destroyerShip.readyToShoot();
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int damage){
		this.live -= damage;
		this.destroyerShip.readyToShoot();
		return false;
	}

	@Override
	public void move() {
		if(this.x + 1 <= 8) {
			this.x++;
		}
		else {
			this.live = 0;
			this.destroyerShip.readyToShoot();
		}
	}

	@Override
	public String stringify() {
		String s = "B;" + this.x + "," + this.y;
		return s;
	};
	
	
	
}
