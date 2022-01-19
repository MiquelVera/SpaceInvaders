package logic;

import java.io.BufferedReader;
import java.util.Random;

import exception.CommandExecuteException;
import view.BoardPrinter;
import view.PrinterTypes;

public class Game {
	
	/*Nuevas variables*/
	private GameObjectBoard board;
	private UCMShip ucmShip;
	private BoardInitializer initializer;
	private int supermisil;
	private PrinterTypes printer;
	

	private Level level;
	private Random rand;
	public static int rows = 8;
	public static int cols = 9;
	private int cycles;
	private int score;
	
	private boolean shockWave; //shockWave available/not available
	private boolean ucmLaserInScreen; //UCMShipLaser created/not created
	private boolean aliensWin; //Only true if aliens have won
	private boolean playerWins;
	
	private boolean exit;
	private boolean reset;
	

	private UCMShipLaser ucmShipLaser;
	private Ovni ufo;
	
	public Game(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		initializer = new BoardInitializer();
		initGame();
	}
	
	public void initGame() {
		this.cycles = 0;
		this.score = 0;
		board = initializer.initialize(this, this.level);
		ucmShip = new UCMShip(this, 7, 4);
		board.add(ucmShip);
		this.supermisil = 0;
		
		this.printer = PrinterTypes.BOARDPRINTER;
		printer.getObject(this).setGame(this);
		
		this.aliensWin = false;
		this.playerWins = false;
		
		this.exit = false;
		this.reset = false;

		this.shockWave = false;
		this.ufo = null;
		this.ucmLaserInScreen = false;
		

	}
	
	/*Execute commands*/
	
	public boolean shootIsPossible() {//if ucmLaserInScreen is true, then shoot is not available and viceversa
		return !this.ucmLaserInScreen;
	}
	
	public void shoot() {
		UCMShipLaser laser= new UCMShipLaser(this, ucmShip.getX(), ucmShip.getY());
		board.add(laser);
		this.ucmLaserInScreen = true;
		/*
		this.ucmShipLaser = new UCMShipLaser(this, this.ucmShip.getX(), this.ucmShip.getY());
		this.ucmLaserInScreen = true;
		*/
	}
	
	public boolean shockWaveIsPossible() {//if ucmLaserInScreen is true, then shoot is not available and viceversa
		return this.shockWave;
	}
	
	public void shockWave() {
		//Damage to all alien ships except UFO, ONLY if we have shockWave available
		if(this.shockWave) {
			ShockWave shockWave = new ShockWave(this, -1, -1, 1);
			board.add(shockWave);
			this.shockWave = false;
		}
	}
	
	public void move(String s, int n) throws CommandExecuteException {
		//Move the ship "n" spaces with the given direction at "s"
		this.ucmShip.move(s,n);
	}
	
	public boolean ucmShipLaserAt(int x, int y) {
		boolean found = false;
		if(this.ucmLaserInScreen && this.ucmShipLaser.objectAt(x, y)) {
			found = true;
		}
		return found;
	}
	
	
	
	
	
	/*Computer action*/
	
	public void computerAction() {
		board.computerAction();
	}

	
	
	
	
	
	/*Update*/
	
	public void update() {
		this.board.computerAction();
		this.board.update();
		this.cycles++;
	}
	
	
	
	
	/*Drawing methods*/
	
	public String toStringObjectAt(int i, int j) {
		String s = board.toString(i, j);
		if(s.equals(null)) {
			s = "";
		}
		return s;
	}
	
	public String toString() {
		System.out.println("Life: " + this.ucmShip.getLife());
		System.out.println("Number of cycles: " + this.cycles);
		System.out.println("Score: " + this.score);
		System.out.println("Remaining aliens: " + getRemainingAliens());
		System.out.println("ShockWave: " + boolTranslator(this.shockWave));
		System.out.println("SuperMissil: " + this.supermisil);
		BoardPrinter boardPrinter = new BoardPrinter(this);
		return boardPrinter.toString();
	}
	
	public String boolTranslator(boolean b) { //We create a boolean translator that exchanges true/false values for yes/no
		String s;
		if(b) {
			s = "YES";
		}
		else {
			s = "NO";
		}
		return s;
	}

	public void ufoHit() {
		this.ucmLaserInScreen = false;
		this.ucmShipLaser = null;
	}
	
	public void addPoints(int n) {
		this.score = this.score + n;
	}
	
	public void setShockWave() {
		this.shockWave = true;
	}
	
	public int getRemainingAliens() {
		return board.getRemainigAliens();
	}
	
	public void aliensWin() {
		this.aliensWin = true;
	}
	
	public void playerWins() {
		this.playerWins = true;
	}
	
	public boolean getAliensWin() {
		return this.aliensWin;
	}
	
	public boolean getPlayerWins() {
		return board.playerWins();
	}

	public void exit() {
		this.exit = true;
	}

	public void reset() {
		board.reset();
		this.reset = true;
	}
	
	public boolean getExit() {
		return this.exit;
	}

	public boolean getReset() {
		return this.reset;
	}

	public boolean isOnBoard(int x, int y) {
		return false;
	}

	public Random getRandom() {
		return this.rand;
	}

	public Level getLevel() {
		return this.level;
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}

	public int getUCMShipLive() {
		return this.ucmShip.getLive();
	}

	public int getCycles() {
		return this.cycles;
	}

	public int getScore() {
		return this.score;
	}

	public String getShockWave() {
		String s = "NO";
		if(shockWave) {
			s = "YES";
		}
		return s;
	}

	public String stringify() {
		String s = null;
		s ="- Space Invaders v2.0 -" + "\n" + "\n";
		s += "L;" + this.level.toString() + "\n";
		s += board.stringify();
		return s;
	}

	public void addExplosiveShip(ExplosiveShip explosiveShip) {
		board.addExplosiveShip(explosiveShip);
	}

	public void setShootIsPossible(boolean b) {
		this.ucmLaserInScreen = !b;
	}

	public void shootSupermisil() {
		UCMShipSuperMissil spr= new UCMShipSuperMissil(this, ucmShip.getX(), ucmShip.getY());
		board.add(spr);
		this.ucmLaserInScreen = true;
		this.useSuperMissil();
	}

	public boolean buyIsPossible(int price) {
		boolean possible = false;
		if(this.score >= price) {
			possible = true;
		}
		return possible;
	}

	public void buySuperMissil() {
		this.supermisil += 1;
		this.score -= 20;
	}

	public int getSupermisil() {
		return this.supermisil;
	}
	
	public void useSuperMissil() {
		this.supermisil--;
	}
	
	public String draw() {
		return this.printer.getObject(this).toString();
	}

	public void changeToStringify() {
		this.printer = PrinterTypes.STRINGIFIER;
		printer.getObject(this).setGame(this);
	}

	public void changeToBoardPrinter() {
		this.printer = PrinterTypes.BOARDPRINTER;
		printer.getObject(this).setGame(this);
	}

	public void list() {
		board.list();
	}

}

