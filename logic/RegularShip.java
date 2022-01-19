package logic;

import java.util.Random;

public class RegularShip extends AlienShip{
	private int points;
	
	public static final String list = "R[2]: RegularShip";
	
	
	public RegularShip(Game game, int x, int y, int speed) {
		super(game, x, y, 2, speed, speed, "izq", 0, false);
		this.points = 5;
	}
	
	public boolean objectAt(int x, int y) {
		boolean b = false;
		if(this.x == x && this.y == y) {
			b = true;
		}
		return b;
	}
	
	public String toString() {
		String s = "R[" + this.live + "]";
		return s;
	}

	public void shockWave() {
		this.live--;
		if(this.live <= 0) {
			this.live = 0;
		}
	}

	public void damage(int damage) {
		this.live = this.live - damage;
		if(this.live <= 0) {
			this.live = 0;
		}
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
	public void computerAction() {
		Random rand = this.game.getRandom();
		if(rand.nextDouble() <= 0.05) {
			this.game.addExplosiveShip(new ExplosiveShip(this.game, this.x, this.y, this.live, this.speed, this.cyclesToMove, this.dir, SHIPS_ON_BORDER, IS_IN_FINAL_ROW));
			AlienShip.REMAINING_ALIENS = AlienShip.REMAINING_ALIENS - 1;
			if(SHIPS_ON_BORDER > REMAINING_ALIENS) {
				SHIPS_ON_BORDER = REMAINING_ALIENS;
			}
		}
	
	}

	@Override
	public void onDelete() {
		
	}
	
	//public boolean performAttack(GameObject other) {return false;};
	public boolean receiveMissileAttack(int damage) {
		this.live -= damage;
		if(this.live <= 0) {
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
		if(this.live <= 0) {
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
		String s = "R;" + this.x + "," + this.y + ";" + this.live + ";" + this.cyclesToMove + ";" + this.dir;
		return s;
	};
	
}
