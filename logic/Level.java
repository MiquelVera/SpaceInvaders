package logic;

public enum Level {
	EASY,
	HARD,
	INSANE;
	
	private int regularShip;
	private int destroyerShip;
	private double shotFreq;
	private int speed;
	private double ufo;
	
	public int getRegularShip() {
		switch(this) {
			case EASY: {
				this.regularShip = 4;
			}
			break;
			
			case HARD: {
				this.regularShip = 8;
			}
			break;
			
			case INSANE: {
				this.regularShip = 8;
			}
			break;
		}
		
		return this.regularShip;
	}
	
	
	public int getDestroyerShip() {
		switch(this) {
			case EASY: {
				this.destroyerShip = 2;
			}
			break;
			
			case HARD: {
				this.destroyerShip = 2;
			}
			break;
			
			case INSANE: {
				this.destroyerShip = 4;
			}
			break;
		}
		
		return this.destroyerShip;
	}
	

	public double getShotFreq() {
		switch(this) {
			case EASY: {
				this.shotFreq = 0.1;
			}
			break;
			
			case HARD: {
				this.shotFreq = 0.3;
			}
			break;
			
			case INSANE: {
				this.shotFreq = 0.5;
			}
			break;
		}
		
		return this.shotFreq;
	}
	
	
	public int getSpeed() {
		switch(this) {
			case EASY: {
				this.speed = 3;
			}
			break;
			
			case HARD: {
				this.speed = 2;
			}
			break;
			
			case INSANE: {
				this.speed = 1;
			}
			break;
		}
		
		return this.speed;
	}
	
	
	public double getUfo() {
		switch(this) {
			case EASY: {
				this.ufo = 0.5;
			}
			break;
			
			case HARD: {
				this.ufo = 0.2;
			}
			break;
			
			case INSANE: {
				this.ufo = 0.1;
			}
			break;
		}
		
		return this.ufo;
	}
}
