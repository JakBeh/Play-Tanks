package break_out.model;

import break_out.Constants;;

/**
 * Dieses Objekt enthaelt die Informationen fuer einen Ball
 * 
 * @author Jakob Behnke
 * @author Ole Engelhardt
 *
 */
public class Ball {

	/**
	 * Die aktuelle Position des Balles
	 */
	private Position pos;
	
	/**
	 * Die momentane Richtung des Balles
	 */
	private Vector2D direction;
	
	/**
	 * Konstruktor fuer einen Ball in der Mitte des unteren Randes,
	 * mit Richtungsvektor (5, -5), normalisiert
	 */
	public Ball(){
		pos = new Position(((Constants.SCREEN_WIDTH - Constants.BALL_DIAMETER) / 2),
				(Constants.SCREEN_HEIGHT - Constants.BALL_DIAMETER - Constants.PADDLE_HEIGHT ));
		
		direction = new Vector2D(5, -5);
		direction.rescale();
	}
	
	/**
	 * Getter fuer die Position des Balles
	 * @return Position, Gibt die aktuelle Position des Balles wieder
	 */
	public Position getPosition(){
		return pos;
	}
	
	/**
	 * Getter fuer den Richtungsvektor des Balles
	 * @return Vector2D, Gibt den aktuellen Richtungsvektor des Balles wieder
	 */
	public Vector2D getDirection(){
		return direction;
	}
	
	/**
	 * Methode, zur Aktualisierung der Position des Balles,
	 * aus aktueller Position (pos) + aktuellem Richtungsvektor (direction)
	 */
	public void updatePosition(){
		pos.setX(pos.getX() + direction.getDx());
    	pos.setY(pos.getY() + direction.getDy());
	}
	
	/**
	 * Methode zur Ueberpruefung, ob der Ball die Raender des Fensters
	 * ueberschreitet
	 */
	public void reactOnBorder(){
		
		if(pos.getX() < 0){
    		direction.setDx(-1 * direction.getDx());
    		pos.setX(0);
		}
		
    	if(pos.getX() > Constants.SCREEN_WIDTH - (Constants.BALL_DIAMETER)){
    		direction.setDx(-1 * direction.getDx());
    		pos.setX(Constants.SCREEN_WIDTH - Constants.BALL_DIAMETER);
    	}
    	
    	if(pos.getY() < 0){
    		direction.setDy(-1 * direction.getDy());
    		pos.setY(0);
    	}
	}
	/**
	 * Methode zur Ueberpruefung, ob der Ball ein Paddle beruehrt
	 * @param p Paddle, an dem die Kollision getestet wird
	 * @return Boolean, ob eine Kollision erfolgt oder nicht
	 */
	public boolean hitsPaddle(Paddle p){
		boolean state;
		
		if(((this.pos.getY() + Constants.BALL_DIAMETER) > p.getPosition().getY())
				&& ((this.pos.getX() + Constants.BALL_DIAMETER) > p.getPosition().getX())
				&& (this.pos.getX() < (p.getPosition().getX() + Constants.PADDLE_WIDTH))){
			state = true;
		}else{
			state = false;
		}
		
		return state;
	}
	
	/**
	 * Methode, die das Abprallverhalten des Balles berechnet
	 * @param paddle Paddle, an dem der Ball abprallt
	 */
	public void reflectOnPaddle(Paddle paddle){
		Position posBall = new Position(this.pos.getX() + (Constants.BALL_DIAMETER / 2), this.pos.getY() + (Constants.BALL_DIAMETER / 2));
		
		Position reflektPunkt = new Position(paddle.getPosition().getX() + (Constants.PADDLE_WIDTH / 2), paddle.getPosition().getY() + 32);
		
		if(this.hitsPaddle(paddle) == true){
			this.direction = new Vector2D(reflektPunkt, posBall);
			this.direction.rescale();
		}
	}
	
	/**
	 * Methode zum Abprallen des Balles von Steinen
	 * Falls kein Stein getroffen wird, ist Rueckgabe [-1, -1],
	 * ansonsten die Koordianten des Feldes des Steines
	 * @param level Int[][], das Steine-Muster aus Level
	 * @return int[], Koordinaten der Flaeche, in dem der getroffene Stein liegt
	 */
	public int[] hitsStone(int[][] level){
		// Setzt die Standartwerte
		int[] value = {-1, -1};
		
		// Konstanten fuer Masse der Steine
		double stoneX = (Constants.SCREEN_WIDTH/Constants.SQUARES_X);
		double stoneY = (Constants.SCREEN_HEIGHT/Constants.SQUARES_Y);
		
		// Variablen fuer Ball-Position
		double ballX = this.pos.getX();
		double ballY = this.pos.getY();
		
		// Verschiebt den Kollisionpunkt des Balles, abhaengig von Bewegungsrichtung
		if(this.direction.getDx() > 0){
			ballX = ballX + Constants.BALL_DIAMETER;
		}
		if(this.direction.getDy() > 0){
			ballY = ballY + Constants.BALL_DIAMETER;
		}
		
		// Testet, in welchem Feld der Ball ist
		int ballSquareX = (int)(ballX / stoneX);
		int ballSquareY = (int)(ballY / stoneY);
		
		// Setzt den Wert an den Kanten zurueck, verhindert ArrayOutOfBounds
		if(ballSquareX > Constants.SQUARES_X - 1){
			ballSquareX = ballSquareX - 1;
		}
		if(ballSquareY > Constants.SQUARES_Y - 1){
			ballSquareY = ballSquareY-1;
		}
		
		// Testet, ob im Feld des Balles ein Stein ist und setzt Rueckgabewert auf diese Position
		if(level[ballSquareY][ballSquareX] > 0){
			// Testet, ob Ball von links, bzw rechts den Stein beruehrt
			if(((this.pos.getX() + Constants.BALL_DIAMETER/2) < (ballSquareX * stoneX)) || ((this.pos.getX() + Constants.BALL_DIAMETER/2) > (ballSquareX * stoneX + stoneX))){
				this.direction.setDx(this.direction.getDx() * -1);
			}else{
				// Im anderen Fall kommt der Ball von oben bzw unten
				this.direction.setDy(this.direction.getDy() * -1);
			}
			value[0] = ballSquareY;
			value[1] = ballSquareX;
		}
		
		
		
		return value;
	}
	
	/**
	 * Methode zum Testen, ob Ball untere Wand beruehrt
	 * @return boolean, ob untere Wand beruehrt wird
	 */
	public boolean beruehrtUntereWand(){
		if(pos.getY() > Constants.SCREEN_HEIGHT - (Constants.BALL_DIAMETER)){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Methode zum Zuruecksetzten von Position und Richtung des Balles beim Verlust des Balles
	 */
	public void reset(){
		pos.setX((Constants.SCREEN_WIDTH - Constants.BALL_DIAMETER) / 2);
		pos.setY(Constants.SCREEN_HEIGHT - Constants.BALL_DIAMETER - Constants.PADDLE_HEIGHT);
		direction = new Vector2D(5, -5);
		direction.rescale();
	}
}