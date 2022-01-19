package control;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;

public abstract class Command {
	protected final String name;
	protected final String shortCut;
	private final String details ;
	private final String help;
	
	private final boolean needsToDraw;
	
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String incorrectArgsMsg = "Incorrect argument format";

	public Command(String name, String shortCut, String details, String help, boolean needsToDraw){
		this.name = name;
		this.shortCut = shortCut;
		this.details = details;
		this.help = help;
		this.needsToDraw = needsToDraw;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	protected boolean matchCommandName(String name) {
		return this.shortCut.equalsIgnoreCase(name) ||
		this.name.equalsIgnoreCase(name);
	}
	
	public String helpText(){
	return details + " : " + help + "\n";
	}
	
	public boolean needsToDraw() {
		return this.needsToDraw;
	}
}
