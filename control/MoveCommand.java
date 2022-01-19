package control;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;

public class MoveCommand extends Command{

	private String dir;
	private int n;
	
	public MoveCommand() {
		super("move", "m", "[M]ove <left|right> <1|2>", "Moves the UCMShip to the given position", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.move(dir, n);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		if(this.matchCommandName(commandWords[0])) {
			
			if(commandWords.length == 3) {
				if(commandWords[1].equalsIgnoreCase("left") || commandWords[1].equalsIgnoreCase("l") || commandWords[1].equalsIgnoreCase("right") || commandWords[1].equalsIgnoreCase("r")) {
					if(commandWords[2].equalsIgnoreCase("1") || commandWords[2].equalsIgnoreCase("2")) {
						c = this;
						this.dir = commandWords[1];
						this.n = Integer.parseInt(commandWords[2]);
					}
					else {
						throw new CommandParseException("ERROR: Invalid move position. It must be [1 | 2]");
					}
				}
				else {
					throw new CommandParseException("ERROR: Invalid move direction. It must be [left | right]");
				}
			}
			else {
				throw new CommandParseException("ERROR: Move command needs direction [left | right] and position [1 | 2] values");
			}
			
			
		}
		
		return c;
	}

}