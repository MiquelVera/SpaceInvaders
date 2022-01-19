package control;

import exception.CommandParseException;
import logic.Game;

public class ListCommand extends Command{

	public ListCommand() {
		super("list", "l", "[L]ist", "Shows a list of all the elements in the game", false);
	}

	@Override
	public boolean execute(Game game) {
		game.list();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: List command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}
}
