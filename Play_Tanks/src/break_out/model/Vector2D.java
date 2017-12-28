package break_out.model;

import break_out.Constants;

/**
 * Dieses Objekt enthaelt deinen Vektor, genutzt fuer den Ball
 * 
 * @author Jakob Behnke
 * @author Ole Engelhardt
 *
 */
public class Vector2D {
	
	/**
	 * Momentane Aenderung von x
	 */
	private double dx = 0;
	
	/**
	 * Momentane Aenderung von y
	 */
	private double dy = 0;
	
	/**
	 * Konstruktor fuer ein Objekt Vector2D mit
	 * @param dx Double, Wert fuer dx
	 * @param dy Double, Wert fuer dy
	 */
	public Vector2D(double dx, double dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * Konstruktor fuer ein Objekt Vector2D mir
	 * @param position1 Position, Startpunkt des Vektor (dx, dy)
	 * @param position2 Position, Endpunkt des Vektor (dx, dy)
	 */
	public Vector2D(Position position1, Position position2){
		this.dx = position2.getX() - position1.getX();
		this.dy = position2.getY() - position1.getY();
	}
	
	/**
	 * Getter fuer dx
	 * @return Double, Wert von dx
	 */
	public double getDx(){
		return this.dx;
	}
	
	/**
	 * Getter fuer dy
	 * @return Double, Wert von dy
	 */
	public double getDy(){
		return this.dy;
	}
	
	/**
	 * Setter fuer dx
	 * @param dx Double, Wert fuer dx
	 */
	public void setDx(double dx){
		this.dx = dx;
	}
	
	/**
	 * Setter fuer dy
	 * @param dy Double, Wret fuer dy
	 */
	public void setDy(double dy){
		this.dy = dy;
	}
	
	/**
	 * Methode zur Normalisierung des Vektors (dx, dy) auf Laenge 1 und Faktorisierung ihn mit Konstante BALL_SPEED.
	 * Dient zur Regulierung der Geschwindigkeit des Balles
	 */
	public void rescale(){
		double betrag =  Math.sqrt(this.dx * this.dx + this.dy * this.dy);
		this.dx = this.dx * (1 / betrag);
		this.dy = this.dy * (1 / betrag);
		
		this.dx = this.dx * Constants.MISSLE_SPEED;
		this.dy = this.dy * Constants.MISSLE_SPEED;
	}
	
	public void scale(double scalar){
		this.dx = this.dx * scalar;
		this.dy = this.dy * scalar;
	}
}