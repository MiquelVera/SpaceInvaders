package logic;

public class ExplosiveShip extends AlienShip {
	
	private int points;
	public static final String list = "E[2]: ExplosiveShip";

	public ExplosiveShip(Game game, int x, int y, int live, int speed, int speedCycle, String dir, int ships_on_border, boolean final_row) {
		super(game, x, y, live, speed, speedCycle, dir, ships_on_border, final_row);
		this.points = 5;
	}

	@Override
	public void computerAction() {
	}

	@Override
	public void onDelete() {
	}
	
	public int getLive() {
		return this.live;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getX() { 
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		String s = "E[" + this.live + "]";
		return s;
	}
	
	//public boolean performAttack(GameObject other) {return false;};
	public boolean receiveMissileAttack(int damage) {
		this.live -= damage;
		if(!this.isAlive()) {
			Explosion e = new Explosion(game, this.x, this.y);
			game.addObject(e);
			game.addPoints(this.points);
			AlienShip.REMAINING_ALIENS--;
			if(SHIPS_ON_BORDER > REMAINING_ALIENS) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
		return true;
	};
	
	//public boolean receiveBombAttack(int damage) {return false;};
	public boolean receiveShockWaveAttack(int damage) {
		this.live -= damage;
		if(!this.isAlive()) {
			Explosion e = new Explosion(game, this.x, this.y);
			game.addObject(e);
			game.addPoints(this.points);
			AlienShip.REMAINING_ALIENS--;
			if(SHIPS_ON_BORDER > REMAINING_ALIENS) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
		return true;
	}
	
	public boolean receiveSuperMissileAttack(int damage) {
		this.live -= damage;
		if(this.live <= 0) {
			game.addPoints(this.points);
			AlienShip.REMAINING_ALIENS--;
			if(SHIPS_ON_BORDER > REMAINING_ALIENS) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
		return true;
	}

	@Override
	public String stringify() {
		String s = "E;" + this.x + "," + this.y + ";" + this.live + ";" + this.cyclesToMove + ";" + this.dir;
		return s;
	}

}
