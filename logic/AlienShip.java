package logic;

public abstract class AlienShip extends EnemyShip {

	protected static int REMAINING_ALIENS = 0;
	protected static boolean IS_IN_FINAL_ROW;
	protected static int SHIPS_ON_BORDER;
	
	protected String dir;
	
	protected int speed;
	protected int cyclesToMove;
	
	public AlienShip(Game game, int x, int y, int live, int speed, int cyclesToMove, String dir, int ships_on_border, boolean final_row) {
		super(game, x, y, live);
		this.speed = speed;
		this.cyclesToMove = cyclesToMove;
		AlienShip.REMAINING_ALIENS += 1;
		AlienShip.IS_IN_FINAL_ROW = final_row;
		AlienShip.SHIPS_ON_BORDER = ships_on_border;
		this.dir = dir;
	}

	@Override
	public void move() {
		
		if(cyclesToMove == 0) {
			cyclesToMove = this.speed;
			if(this.dir.equalsIgnoreCase("izq")) {
				this.y--;
			}
			else {
				this.y++;
			}
			if(this.x == (Game.rows - 1)) {
				AlienShip.IS_IN_FINAL_ROW = true;
			}
			else {
				AlienShip.IS_IN_FINAL_ROW = false;
			}
			if(this.y == (Game.cols - 1)|| this.y == 0) {
				AlienShip.SHIPS_ON_BORDER = AlienShip.REMAINING_ALIENS;
			}
			
		}
		else if((AlienShip.SHIPS_ON_BORDER > 0) && !AlienShip.IS_IN_FINAL_ROW) {
			this.x++;
			flipDir();
			AlienShip.SHIPS_ON_BORDER = AlienShip.SHIPS_ON_BORDER - 1;
			cyclesToMove = 0;
			
			if(this.x == (Game.rows - 1)) {
				game.aliensWin();
			}
		}
		else{
			this.cyclesToMove--;
		}
	}

	private void flipDir() {
		if(this.dir.equalsIgnoreCase("izq")) {
			this.dir = "dcha";
		}
		else {
			this.dir = "izq";
		}
	}

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract String toString();
	
	
	public void reset() {
		REMAINING_ALIENS = 0;
	}
	
}
