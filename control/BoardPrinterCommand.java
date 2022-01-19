package control;

import exception.CommandParseException;
import logic.Game;

public class BoardPrinterCommand extends Command {

	public BoardPrinterCommand() {
		super("boardprinter", "bp", "[B]oard[P]rinter", "Changes the game vision to it's start value (board)", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		boolean b = false;
		game.changeToBoardPrinter();
		return b;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		// TODO Auto-generated method stub
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: BoardPrinter command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}
