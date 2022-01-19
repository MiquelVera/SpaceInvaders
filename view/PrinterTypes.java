package view;

import logic.Game;

public enum PrinterTypes {
	BOARDPRINTER("boardprinter",
		"prints the game formatted as a board of dimension: ",
		new BoardPrinter()),
	STRINGIFIER("stringifier",
		"prints the game as plain text",
		new Stringifier() );
	
	private String name;
	private String text;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		this.name = name;
		this.text = text;
		this.printerObject = printer;
		
	}
	public static String printerHelp(Game game) {
		return null;
	}
	public GamePrinter getObject(Game game) {
		printerObject. setGame(game);
		return printerObject;
	}
	
}
