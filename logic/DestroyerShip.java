package logic;

import java.util.Random;

public class DestroyerShip extends AlienShip{
	private int points;
	private boolean shot;
	
	public static final String list = "D[1]: DestroyerShip";
	
	private Game game;
	
	public DestroyerShip(Game game, int x, int y, int speed) {
		super(game, x, y, 1, speed, speed, "izq", 0, false);
		this.points = 10;
		this.game = game;
		this.shot = false;
	}
	
	public boolean objectAt(int x, int y) {
		boolean b = false;
		if(this.x == x && this.y == y) {
			b = true;
		}
		return b;
	}
	
	public String toString() {
		String s = "D[" + this.live + "]";
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
			game.addPoints(this.points);
		}
	}
	
	public void readyToShoot() {
		this.shot = false;
	}
	
	
	public boolean getShot() {
		return this.shot;
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
		Random rand = game.getRandom();
		Level level = game.getLevel();
		Double freq = level.getShotFreq();
		
		if(!this.shot && rand.nextDouble() < freq) {
			Bomb b = new Bomb(game, this.x, this.y, this);
			game.addObject(b);
			shot = true;
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
		String s = "D;" + this.x + "," + this.y + ";" + this.live + ";" + this.cyclesToMove + ";" + this.dir;
		return s;
	};
	
}
