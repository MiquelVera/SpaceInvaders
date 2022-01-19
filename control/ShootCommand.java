package control;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;

public class ShootCommand extends Command{

	private boolean supermisil;
	
	public ShootCommand() {
		super("shoot", "s", "[S]hoot ([S]uper[M]issil)", "Shoots a Missil or a SuperMissil", true);
		this.supermisil = false;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		boolean b = true;
		if(game.shootIsPossible()) {
			if(!this.supermisil){
				game.shoot();
			}
			else{
				if(game.getSupermisil() > 0) {
					game.shootSupermisil();
					this.supermisil = false;
				}
				else {
					b = false;
					throw new CommandExecuteException("You can't shoot a supermissil because you have none. You can buy one with 'buy' or 'b'.");
					
				}
			}
			
		}
		else {
			b = false;
			throw new CommandExecuteException("You can't shoot because there's a missil or supermissil already on screen");
			
		}
		return b;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length == 2){
				if(commandWords[1].equalsIgnoreCase("supermisil") || commandWords[1].equalsIgnoreCase("sm")){
					this.supermisil = true;
				}
				else {
					c = null;
					throw new CommandParseException("ERROR: Shoot supermissil command needs the following format: [shoot supermissil | s sm]");
				}
				
			}
			c = this;
			
		}
		
		return c;
	}

}