package logic;

public class ShockWave extends Weapon {
	
	public ShockWave(Game game, int x, int y, int live) {
		super(game, x, y, live, 1);
	}

	public boolean performAttack(GameObject other) {
		if(!(other instanceof UCMShip || other instanceof UCMShipLaser ||other instanceof UCMShipSuperMissil)) {
			other.receiveShockWaveAttack(this.damage);
			this.live = 0;
		}
		return false;
	}

	@Override
	public void move() {
		
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public String stringify() {
		return null;
	};
	//public boolean receiveMissileAttack(int damage) {return false;};
	//public boolean receiveBombAttack(int damage) {return false;};
	//public boolean receiveShockWaveAttack(int damage) {return false;};
	
	
}
