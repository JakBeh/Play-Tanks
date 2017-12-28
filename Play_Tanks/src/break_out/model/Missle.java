package break_out.model;

import break_out.Constants;

public class Missle {

	private int damage;
	
	private Position position;
	
	private Vector2D direction;
	
	public Missle(Position position, Vector2D direction){
		this.damage = 10;
		this.position = position;
		this.direction = direction;
	}
	//TODO add possible constructors for diff. damage
	public Missle(){
		this.damage = 10;
		this.position = new Position(-10, -10);
		this.direction = new Vector2D(0, 0);
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public Position getPosition(){
		return this.position;
	}
	
	public void setDirection(Vector2D direction){
		this.direction = direction;
	}
	
	public boolean hitShip(Ship player1, Ship player2){
		return false;
		//if()
	}
	
	public void updateDirection(){
		this.position.setX(this.position.getX() + this.direction.getDx());
		this.position.setY(this.position.getY() + this.direction.getDy());
		this.direction.setDy(this.direction.getDy() - Constants.GRAVITY);
	}
	
	public void reset(){
		this.position = new Position(-10, -10);
		this.direction = new Vector2D(0, 0);
	}
	
	public void shot(Position origin, int strength, Vector2D angle){
		this.position = origin;
		this.direction = angle;
		this.direction.rescale();
	}
}
