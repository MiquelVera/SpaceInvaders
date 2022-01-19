package control;

import exception.CommandParseException;
import logic.Game;

public class ResetCommand extends Command{

	public ResetCommand() {
		super("reset", "r", "[R]eset", "Resets the game", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.reset();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: Reset command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}