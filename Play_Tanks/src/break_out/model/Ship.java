package break_out.model;

import break_out.Constants;
import java.util.concurrent.ThreadLocalRandom;

public class Ship {

	private Position position;
	
	private int strength;
	
	private Vector2D angle;
	
	private int health;
	
	private int direction;
	
	public Ship(){
		this.position = new Position((ThreadLocalRandom.current().nextInt(0, Constants.SCREEN_WIDTH + Constants.SHIP_WIDTH + 1)),400);
		this.strength = 0;
		this.angle = new Vector2D(0,0);
		this.health = 100;
	}
	
	public Ship(Position position){
		this.position = position;
		this.strength = 0;
		this.angle = new Vector2D(0,0);
		this.health = 100;
	}
	
	public Ship(Position position, int health) {
		this.position = position;
		this.strength = 0;
		this.angle = new Vector2D(0,0);
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public Vector2D getAngle() {
		return this.angle;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int dx) {
		this.direction = dx;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Methode zur Veraenderung des Paddles in Abhaengigkeit von direction, um Wert DX_MOVEMENT
	 */
	public void updatePosition(){
		if(this.direction == 1){
			position.setX(position.getX() + Constants.DX_MOVEMENT);
		}else if(this.direction == -1){
			position.setX(position.getX() - Constants.DX_MOVEMENT);
		}
		
		if(position.getX() > (Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH)){
			position.setX(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH);
		}
		
		if(position.getX() < 0){
			position.setX(0);
		}
	}
}
