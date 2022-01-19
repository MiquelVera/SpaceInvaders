package logic;

import exception.CommandExecuteException;

public class UCMShip extends Ship{
	private String screen;
	
	public static final String list = "^__^: UCMShip";
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, 3);
		this.screen = "^__^";
	}

	public int getLife() {
		return this.live;
	}

	public boolean objectAt(int i, int j) {
		boolean b = false;
		if(this.x == i && this.y == j) {
			b = true;
		}
		return b;
	}

	public String toString() {
		return this.screen;
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public void move(String s, int n) throws CommandExecuteException {
		if(s.equals("left") || s.equals("l")) {
			if(this.y - n < 0) {
				this.y = 0;
				throw new CommandExecuteException("ERROR: UCMShip can't surpass the left border");
			}
			else {
				this.y = this.y - n;
			}
		}
		else {
			if(this.y + n > 8) {
				this.y = 8;
				throw new CommandExecuteException("ERROR: UCMShip can't surpass the right border");
			}
			else {
				this.y = this.y + n;
			}
		}
	}

	public void damage(int x, int y, int damage) {
		this.live = this.live - damage;
		if(this.live <= 0) {
			this.live = 0;
			this.screen = "!xx!";
		}
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public void onDelete() {
		
	}

	@Override
	public void move() {
		if(this.live == 0) {
			this.screen = "!xx!";
			game.aliensWin();
		}
	}
	
	//public boolean performAttack(GameObject other) {return false;};
	//public boolean receiveMissileAttack(int damage) {return false;};
	public boolean receiveBombAttack(int damage) {
		this.live -= damage;
		if(this.live == 0) {
			this.screen = "!xx!";
			game.aliensWin();
		}
		return true;
	}

	@Override
	public String stringify() {
		String s = "P;" + this.x + "," + this.y + ";" + this.live + ";" + game.getScore() + ";" + game.shockWaveIsPossible();
		return s;
	};
	//public boolean receiveShockWaveAttack(int damage) {return false;};
	
	public void reset() {
		
	}
}
