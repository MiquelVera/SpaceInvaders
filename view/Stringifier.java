package view;

import logic.Game;

public class Stringifier extends GamePrinter {

	public Stringifier(Game game) {
		super(game);
	}
	
	public Stringifier() {
		super();
	}

	public String toString() {
		String s = null;
		s = this.game.stringify();
		return s;
	}
}
