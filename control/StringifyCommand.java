package control;

import exception.CommandParseException;
import logic.Game;

public class StringifyCommand extends Command {

	public StringifyCommand() {
		super("stringify", "sf", "[S]tringi[F]y", "Changes the visual part of the game to a list of objects", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		boolean b = false;
		game.changeToStringify();
		return b;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: Shockwave command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}
