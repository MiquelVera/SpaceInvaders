package view;

import logic.AlienShip;
import logic.Game;
import util.MyStringUtils;

public class BoardPrinter extends GamePrinter{
	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	
	public BoardPrinter (Game game) {
		super(game);
		this.numRows = Game.rows;
		this.numCols = Game.cols;		
		encodeGame(this.game);
	}
	
	public BoardPrinter () {
		super();
		this.numRows = Game.rows;
		this.numCols = Game.cols;	
	}
	
	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] =  game.toStringObjectAt(i, j);
			}
		}
	}
	
	public String toString() {
		
		System.out.println("Life: " + game.getUCMShipLive());
		System.out.println("Number of cycles: " + game.getCycles());
		System.out.println("Score: " + game.getScore());
		System.out.println("Remaining aliens: " + game.getRemainingAliens());
		System.out.println("ShockWave: " + game.getShockWave());
		System.out.println("SuperMissil: " + game.getSupermisil());
		
		encodeGame(this.game);
		
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
}