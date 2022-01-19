package control;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;

public class ShockwaveCommand extends Command{

	public ShockwaveCommand() {
		super("shockwave", "w", "Shock[W]ave", "Creates a shockWave that damages -1 to every enemy (except Ovni). Only availabla after killing an Ovni", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		boolean b = false;
		if(game.shockWaveIsPossible()) {
			game.shockWave();
			b = true;
		}
		else {
			throw new CommandExecuteException("ShockWave not possible: Kill an Ovni for ShockWave enable");
		}
		
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