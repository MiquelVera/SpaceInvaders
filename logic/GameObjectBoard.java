 package logic;

import control.BoardPrinterCommand;
import control.BuySuperMissilCommand;
import control.Command;
import control.ExitCommand;
import control.HelpCommand;
import control.ListCommand;
import control.MoveCommand;
import control.ResetCommand;
import control.SaveCommand;
import control.ShockwaveCommand;
import control.ShootCommand;
import control.StringifyCommand;
import control.UpdateCommand;

public class GameObjectBoard {
	
	private GameObject[] objects;
	private int currentObjects;

	
	public GameObjectBoard (int cols, int rows) {
	// TODO implement
		currentObjects = 0;
		objects = new GameObject[cols * rows];
	}
	
	private int getCurrentObjects () {
		return this.currentObjects;
	}
	
	public void add(GameObject object) {
		objects[this.getCurrentObjects()] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		for(int i = 0; i < this.getCurrentObjects() ; i++) {
			if(objects[i].getX() == x && objects[i].getY() == y) {
				return objects[i];
			}
		}
		return null;
	}
	
	private int getIndex(int x, int y) {
		for(int i = 0; i < this.getCurrentObjects() ; i++) {
			if(objects[i].getX() == x && objects[i].getY() == y) {
				return i;
			}
		}
		return -1;
	}
	
	private void remove (GameObject object) {
		for(int i = 0; i < this.getCurrentObjects() ; i++) {
			if(objects[i] == object) {
				objects[i] = objects[this.currentObjects - 1];
				this.currentObjects--;
			}
		}
		
	}
	public void update() {
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			objects[i].move();
		}
		for(int j = 0; j < this.getCurrentObjects(); j++) {
			checkAttacks(objects[j]);
		}
		removeDead();
	}
	
	private void checkAttacks(GameObject object) {
		boolean found = false;
		int i = 0;
		while(!found && i < this.getCurrentObjects()) {
			if(object.performAttack(objects[i])) {
				found = true;
			}
			i++;
		}
	}
	
	public void computerAction() {
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			objects[i].computerAction();
		}
	}
	
	private void removeDead() {
		for(int i = 1; i < this.getCurrentObjects() ; i++) {
			if(!objects[i].isAlive() && !(objects[i] instanceof UCMShip)) {
				objects[i] = objects[this.currentObjects - 1];
				this.currentObjects--;
				i--;
			}
		}
	}
	public String toString(int x, int y) {
		GameObject object = getObjectInPosition(x,y);
		if(object == null) {
			return "";
		}
		else {
			return object.toString();
		}

	}

	public String stringify() {
		String s = "";
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			s += this.objects[i].stringify() + "\n";
		}
		return s;
	}

	public void addExplosiveShip(ExplosiveShip explosiveShip) {
		int i = 0;
		boolean encontrar = false;
		while((i < this.getCurrentObjects()) && !encontrar) {
			if((objects[i].getX() == explosiveShip.getX()) && ((objects[i].getY() == explosiveShip.getY()))) {
				objects[i] = explosiveShip;
				encontrar = true;
			}
			i++;
		}
		
	}

	public int getRemainigAliens() {
		int n = 0;
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			if(objects[i] instanceof AlienShip) {
				n++;
			}
		}
		return n;
	}

	public void reset() {
		for(int i = 0; i < this.getCurrentObjects(); i++) {
			objects[i].reset();
		}
	}

	public boolean playerWins() {
		return (this.getRemainigAliens() <= 0);
	}

	public void list() {
		String s = "";
		s += Ovni.list + "\n" + "\n" + UCMShip.list + "\n" + "\n" + UCMShipLaser.list + "\n" + "\n" + UCMShipSuperMissil.list + "\n" + "\n" + RegularShip.list +
				"\n" + "\n" + DestroyerShip.list + "\n" + "\n" + ExplosiveShip.list + "\n" + "\n" + Bomb.list + "\n" + "\n";
		System.out.println(s);
	}


}