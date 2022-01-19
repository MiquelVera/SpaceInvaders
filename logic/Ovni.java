package logic;

import java.util.Random;

public class Ovni extends EnemyShip{
	private int points;
	private boolean onScreen;
	public static final String list = "O[1]: Ovni";
	
	private Game game;
	
	public Ovni(Game game) {
		super(game, 0, 9, 1);
		this.points = 25;
		this.game = game;
		this.onScreen = false;
	}
	

	public boolean objectAt(int x, int y) {
		boolean b = false;
		if(this.x == x && this.y == y) {
			b = true;
		}
		return b;
	}
	
	public String toString() {
		String s = "";
		if(onScreen) {
		s = "O[" + this.live + "]";
		}
		return s;
	}


	@Override
	public void computerAction() {
		Random rand = game.getRandom();
		Level level = game.getLevel();
		Double freq = level.getUfo();               
		
		
		if(!this.onScreen && rand.nextDouble() < freq) {
			this.onScreen = true;
			this.live = 1;
		}
	}

	@Override
	public void onDelete() {

	}

	@Override
	public void move() {
		if(this.live > 0 && this.onScreen) {
			if(this.y > 0) {
				this.y--;
			}
			else {
				this.x = 0;
				this.y = 9;
				this.onScreen = false;
			}
		}
		else if(this.live < 0 && onScreen){
			this.live = 0;
			game.addPoints(this.points);
			game.setShockWave();
			game.ufoHit();
		}
	}
	
	//public boolean performAttack(GameObject other) {return false;};
	public boolean receiveMissileAttack(int damage) {
		this.live = 0;
		this.onScreen = false;
		game.setShockWave();
		game.addPoints(this.points);
		this.x = 0;
		this.y = 9;
		return true;
	}
	public boolean receiveSuperMissileAttack(int damage){
		this.live = 0;
		this.onScreen = false;
		game.setShockWave();
		this.x = 0;
		this.y = 9;
		game.addPoints(this.points);

		return true;
	}

	@Override
	public String stringify() {
		String s = "O;" + this.x + "," + this.y + ";" + this.live;
		return s;
	};
	//public boolean receiveBombAttack(int damage) {return false;};
	//public boolean receiveShockWaveAttack(int damage) {return false;};
	
	public void reset() {
		
	}
}
