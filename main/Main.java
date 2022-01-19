package main;

import java.util.Random;
import control.Controller;
import exception.InvalidArgumentsException;
import logic.Game;
import logic.Level;

public class Main {

	public static void main(String[] args) throws InvalidArgumentsException{
		Level level = null; //Level variable
		long seed; //Seed variable
		Random r = new Random(System.currentTimeMillis()); //We create a Random variable just in case seed value is not given by user

		try {
		
			if(args.length == 1 || args.length == 2) {
				switch(args[0].toUpperCase()){ //We determine the level using the given argument
				case "EASY":{
					level = Level.EASY;
				}
				break;
				
				case "HARD":{
					level = Level.HARD;
				}
				break;
				
				case "INSANE":{
					level = Level.INSANE;
				}
				break;
				
				default: {
					throw new InvalidArgumentsException("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of:\r\n" + 
							"EASY, HARD, INSANE");
				}
				}
				
			}
			else {
				throw new InvalidArgumentsException("Usage: Main <EASY|HARD|INSANE> [seed]");
			}
			
	
			if(args.length != 2) {//We check if there's a seed value given by user
				seed = r.nextLong();//We generate a random seed if seed value isn't given
			}
			else {
				seed = Long.parseLong(args[1]);//We store the value if it's given by user
			}
			
			
			Random rand = new Random(seed);//We create a random number generator using the seed
			Game game = new Game(level, rand);//We create the game with "level" and "random" variable references
			Controller controller = new Controller(game, rand, seed, level);//We create the controller with "game" and "random" variable references
			
			controller.run();//We run "run()" method from controller to start the game
				
					
		}
		
		catch(InvalidArgumentsException a) {
			System.out.println(a.getMessage());
		}
		catch(NumberFormatException n) {
			System.out.println("Usage: Main <EASY|HARD|INSANE> [seed]: the seed must be a number");
		}
		finally {
			
		}
		
	}

}
