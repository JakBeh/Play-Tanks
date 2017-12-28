package break_out.model;

import break_out.Constants;
import java.util.concurrent.ThreadLocalRandom;

public class Ship {

	/**
	 * The position of the ship
	 */
	private Position position;
	
	/**
	 * The strength of the last shot
	 */
	private int strength;
	
	/**
	 * The angle of the last shot
	 */
	private Vector2D angle;
	
	/**
	 * The health of the ship
	 */
	private int health;
	
	/**
	 * The direction the ship is moving
	 */
	private int direction;
	
	/**
	 * The constructor for a ship object with standard health and a random position
	 */
	public Ship(){
		this.position = new Position(ThreadLocalRandom.current().nextInt((int)Constants.SCREEN_WIDTH - (int)Constants.SHIP_WIDTH),400);
		this.strength = 1;
		this.angle = new Vector2D(0,0);
		this.health = 100;
	}
	
	/**
	 * The constructor for a ship object with specific health and a random position
	 * @param health int, The new health value
	 */
	public Ship(int health) {
		this.position = new Position(ThreadLocalRandom.current().nextInt((int)Constants.SCREEN_WIDTH - (int)Constants.SHIP_WIDTH),400);
		this.strength = 1;
		this.angle = new Vector2D(0,0);
		this.health = health;
	}
	
	/**
	 * The constuctor for a ship object with specific health and a specific position
	 * @param health int, The new health value
	 * @param position Position, The new position
	 */
	public Ship(int health, Position position) {
		this.position = position;
		this.strength = 1;
		this.angle = new Vector2D(0,0);
		this.health = health;
	}
	
	/**
	 * The constructor for a ship object with standard health and a specific position
	 * @param position Position, the new position
	 */
	public Ship(Position position) {
		this.position = position;
		this.strength = 1;
		this.angle = new Vector2D(0,0);
		this.health = 100;
	}
	
	/**
	 * Getter method for the health
	 * @return int, the health value of the ship
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * Getter method for the angle
	 * @return Vector2D, the angle of the last shot
	 */
	public Vector2D getAngle() {
		return this.angle;
	}
	
	/**
	 * Getter method for the strength
	 * @return int, the strength of the last shot
	 */
	public int getStrength() {
		return this.strength;
	}
	
	/**
	 * Getter method for the position
	 * @return Position, the position of the ship
	 */
	public Position getPosition() {
		return this.position;
	}
	
	/**
	 * Getter method for direction
	 * @return int, the current direction of the ship
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * Setter method for the direction
	 * @param dx int, the new direction for the ship
	 */
	public void setDirection(int dx) {
		this.direction = dx;
	}
	
	/**
	 * Setter method for the position
	 * @param position Position, the new position for the ship
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * method to change the position by DX_MOVEMENT, depending on direction
	 */
	public void updatePosition(){
		if(this.direction == 1){
			position.setX(position.getX() + Constants.DX_MOVEMENT);
		}else if(this.direction == -1){
			position.setX(position.getX() - Constants.DX_MOVEMENT);
		}
		
		if(position.getX() > (Constants.SCREEN_WIDTH - Constants.SHIP_WIDTH)){
			position.setX(Constants.SCREEN_WIDTH - Constants.SHIP_WIDTH);
		}
		
		if(position.getX() < 0){
			position.setX(0);
		}
	}
	
	public void increaseStrength(){
		if(this.strength < 100){
			this.strength++;
		}
	}
	
	public void decreaseStrength(){
		if(this.strength > 0){
			this.strength--;
		}
	}
}
