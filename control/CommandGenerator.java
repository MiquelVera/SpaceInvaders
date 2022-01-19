package control;

import exception.CommandParseException;

public class CommandGenerator {

	private static Command[] availableCommands = {
		new ListCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new UpdateCommand(),
		new MoveCommand(),
		new ShockwaveCommand(),
		new ShootCommand(),
		new StringifyCommand(),
		new BoardPrinterCommand(),
		new SaveCommand(),
		new BuySuperMissilCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		Command c = null;
		int i = 0;
		boolean found = false;
		while(i < availableCommands.length && !found) {
			c = availableCommands[i].parse(commandWords);
			if(c != null) {
				found = true;
			}
			i++;
		}
		return c;
	}
	
	public static String commandHelp() {
		
		String s = "";
		
		for(int i = 0; i < availableCommands.length; i++) {
			s += availableCommands[i].helpText() + "\n";
		}
		
		return s;
	}
	
}
