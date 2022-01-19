package control;

import exception.CommandParseException;
import logic.Game;

public class HelpCommand extends Command{

	public HelpCommand() {
		super("help", "h", "[H]elp", "Shows a list of all available commands", false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length != 1) {
				c = null;
				throw new CommandParseException("ERROR: Help command only needs 1 parameter");
			}
			c = this;
		}
		
		return c;
	}

}