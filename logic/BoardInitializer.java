package logic;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this. game = game;
		board = new GameObjectBoard(Game.cols, Game.rows);
		initializeOvni ();
		initializeRegularAliens ();
		initializeDestroyerAliens ();
		return board;
	}
	
	private void initializeOvni () {
		Ovni ovni = new Ovni(this.game);
		board.add(ovni);
	}
	
	private void initializeRegularAliens () {
		int size = level.getRegularShip();
		
		switch (this.level) {
		case EASY:{
			//Put the aliens with it's EASY level layout
			int x = 1;
			int y = 3;
			for(int i = 0; i < size; i++) {
				RegularShip rs = new RegularShip(game, x, y, level.getSpeed());
				board.add(rs);
				y++;
			}
		}
		break;
		
		case HARD: {
			//Put the aliens with it's HARD level layout
			int x = 1;
			int y = 3;
			int cont = 0;
			int endLine = size / 2;
			for(int i = 0; i < size; i++) {
				RegularShip rs = new RegularShip(game, x, y, level.getSpeed());
				board.add(rs);
				cont++;
				y++;
				if(cont == endLine) {
					cont = 0;
					x = 2;
					y = 3;
				}
			}
		}
		break;
		
		case INSANE: {
			//Put the aliens with it's INSANE level layout
			int x = 1;
			int y = 3;
			int cont = 0;
			int endLine = size / 2;
			for(int i = 0; i < size; i++) {
				RegularShip rs = new RegularShip(game, x, y, level.getSpeed());
				board.add(rs);
				cont++;
				y++;
				if(cont == endLine) {
					cont = 0;
					x = 2;
					y = 3;
				}
			}
		}
		break;
		}
		
		
	}
	
	private void initializeDestroyerAliens () {
		int size = level.getDestroyerShip();
		
		switch (this.level) {
		case EASY:{
			//Put the aliens with it's EASY level layout
			int x = 2;
			int y = 4;
			for(int i = 0; i < size; i++) {
				DestroyerShip ds = new DestroyerShip(game, x, y, level.getSpeed());
				board.add(ds);
				y++;
			}
		}
		break;
		
		case HARD: {
			//Put the aliens with it's HARD level layout
			int x = 3;
			int y = 4;
			for(int i = 0; i < size; i++) {
				DestroyerShip ds = new DestroyerShip(game, x, y, level.getSpeed());
				board.add(ds);
				y++;
			}
		}
		break;
		
		case INSANE: {
			//Put the aliens with it's INSANE level layout
			int x = 3;
			int y = 3;
			for(int i = 0; i < size; i++) {
				DestroyerShip ds = new DestroyerShip(game, x, y, level.getSpeed());
				board.add(ds);
				y++;
			}
		}
		break;
		}
		
	}
}