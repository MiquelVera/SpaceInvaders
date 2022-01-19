package control;

import logic.Game;

public class UpdateCommand extends Command{

	public UpdateCommand() {
		super("", "", "[U]pdate [enter]", "Doesn't realize any command and simply lets the game go on", true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			c = this;
		}
		
		return c;
	}

}