package logic;

public class Explosion extends Weapon {

	public Explosion(Game game, int x, int y) {
		super(game, x, y, 1, 1);
	}
	
	public boolean performAttack(GameObject other) {
		if((other.getX() == this.x && other.getY() == this.y - 1) || (other.getX() == this.x && other.getY() == this.y + 1) ||(other.getX() == this.x - 1 && other.getY() == this.y) || 
				(other.getX() == this.x + 1 && other.getY() == this.y) || (other.getX() == this.x - 1 && other.getY() == this.y - 1) || (other.getX() == this.x + 1 && other.getY() == this.y + 1) ||
				(other.getX() == this.x + 1 && other.getY() == this.y - 1) || (other.getX() == this.x - 1 && other.getY() == this.y + 1)) {
			other.receiveExplosionAttack(this.damage);
			this.live = 0;
		}
		return false;
	}

	@Override
	public void move() {

	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public String stringify() {
		return null;
	}

}
