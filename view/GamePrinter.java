package view;

import logic.Game;

public abstract class GamePrinter {

	protected Game game;
	
	public GamePrinter(Game game) {
		this.game = game;
	}
	
	public GamePrinter() {
		
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
}
