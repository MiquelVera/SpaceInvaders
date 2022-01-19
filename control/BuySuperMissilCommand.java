package control;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;

public class BuySuperMissilCommand extends Command{

	
	public BuySuperMissilCommand() {
		super("buy", "b", "[B]uy", "Buys a SuperMissil if the player has enough score", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		boolean b = true;
		if(game.buyIsPossible(20)){
			game.buySuperMissil();
		}
		else {
			b = false;
			throw new CommandExecuteException("You don't have enough score to buy a supermissil. SuperMissil's price is: 20");
			
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
				throw new CommandParseException("ERROR: BuySuperMissil command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}