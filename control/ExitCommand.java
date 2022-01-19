package control;

import exception.CommandParseException;
import logic.Game;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit", "e", "[E]xit", "Exits the game", false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: Exit command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}
