package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import exception.CommandExecuteException;
import exception.CommandParseException;
import logic.Game;
import view.Stringifier;

public class SaveCommand extends Command{

	private String fileName;
	private Stringifier stringifier;
	
	public SaveCommand() {
		super("save", "sv", "[S]a[V]e [fileName]", "Saves the game at it's state to a given file", true);
		this.fileName = "";
		this.stringifier = new Stringifier();
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		//Crear el archivo con el nombre de fileName
		//Llamar a Stringifier para que nos de el toString() a guardar
		//Guardarlo en el archivo
		FileWriter fw;
		try {
			fw = new FileWriter(this.fileName + ".dat");
			BufferedWriter bw = new BufferedWriter(fw);
			//Coger el String a escribir de Strigifier
			//Meterlo en bw.write();
			stringifier.setGame(game);
			bw.write(stringifier.toString());
			bw.close();
			fw.close();
			System.out.println("Game successfully saved in file\r\n" + 
					this.fileName + ".dat. Use the load\r\n" + 
					"command to reload it \n");
		} catch (IOException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command c = null;
		
		if(this.matchCommandName(commandWords[0])) {
			if(commandWords.length == 2){
				this.fileName = commandWords[1];
				c = this;
			}
			else {
				throw new CommandParseException("ERROR: Save command needs a file name");
			}
		}
		
		return c;
	}
	
	
	
	
	
	
}