package control;

import java.util.Random;
import java.util.Scanner;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;
import logic.Level;

public class Controller {

	private Game game;
	private Random rand;
	private Level level;
	private boolean draw;
	private Scanner in;
	private long seed;
	
	public Controller(Game game, Random rand, long seed, Level level) {
		this.game = game;
		this.rand = rand;
		this.seed = seed;
		this.level = level;
		this.draw = true;
		this.in = new Scanner(System.in);
	}

	public void run() {
		
		while(!gameOver()) {
			
			if(this.draw) {
				draw();
			}
			
			
			try {
			
					String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
					Command command = CommandGenerator.parseCommand(words);
					
			

			
					if(command != null) {
						
						if(command.execute(game)) {//Needs to update
		
							game.update();
						}
						else {//Doesn't need to update
							if(game.getReset()) {
								this.reset();
							}
						}
						
						//We ask the given command whether we must draw again or not. Controller doesn't have this information, we just store it in a boolean variable.
						this.draw = command.needsToDraw();
						if(!this.draw && !gameOver()) {
							System.out.print("Command > ");
						}
						
					}
					else {
						System.out.println("ERROR: Unknown command");
					}
			
			}
			catch(CommandParseException p) {
				System.out.println(p.getMessage());
			}
			catch(CommandExecuteException e) {
				System.out.println(e.getMessage());
			}
			finally {
				
			}
			
		}
		draw();
		if(game.getAliensWin() || game.getExit()) {
			System.out.println();
			System.out.println("GAME OVER");
			System.out.println();
			System.out.println("Aliens win");
		}
		else if (game.getPlayerWins()) {
			System.out.println();
			System.out.println("GAME OVER");
			System.out.println();
			System.out.println("Player wins!");
		}
	}
	
	/*We create auxiliary methods in order to execute each "run()" method operations*/
	private void draw() {
		System.out.println(this.game.draw());
		System.out.print("Command > ");
	}

	private boolean gameOver() {
		boolean b = false;
		if(game.getAliensWin() || game.getExit()) {
			b = true;
		}
		else if (game.getPlayerWins()) {
			b = true;
		}
		return b;
	}
	
	private void reset() {
		this.rand = new Random(this.seed);
		this.game.reset();
		this.game = new Game(this.level, this.rand);
		draw = true;
	}
}
