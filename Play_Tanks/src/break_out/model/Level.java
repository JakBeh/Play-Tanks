package break_out.model;

import break_out.Constants;
import break_out.controller.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This object contains information about the running game
 * 
 * @author dmlux
 * @author I. Schumacher, modified by Jakob Behnke
 */
public class Level extends Thread {

    /**
     * The game to which the level belongs 
     */
    private Game game;
    
    /**
     * Objekt, das Spieler 1 beschreibt
     */
    private Ship player1;
    
    /**
     * Objekt, das Spieler 2 beschreibt
     */
    private Ship player2;
    
<<<<<<< HEAD
    private Missle missle;
    
    /**
     * Bool to keep track, which player is active
     * True = Player1, False = Player2
     */
    private boolean playerStatus;
    
    /**
     * Bool to prevent another shot, when a missle is flying
     */
    private boolean waitTime;
    
=======
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
    /**
     * Konstante f�r den Wind, der die Schussbahn ver�ndert
     */
    private int wind;
    
<<<<<<< HEAD
    /**
     * Constant for the health, when a costum health is set
     */
=======
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
    private int newHealth;
    
    /**
     * Variable, um Abbruch der while-Schleife zu regeln
     */
    private boolean beendet = false;
        
    /**
     * Der Konstruktor instanziiert einen neuen Level:
     * @param game Das zugehoerige Game-Objekt
     * @param levelnr Die Nummer des zu instanziierenden Levels
     * @param score Der bisher erreichte Scorewert
     */
    public Level(Game game, int levelnr, int score) {
    	this.game = game;
    	//this.wind = ThreadLocalRandom.current().nextInt(-20, 21); //TODO
    	this.newHealth = 0;
<<<<<<< HEAD
    	this.playerStatus = true;
    	this.waitTime = false;
    	if(this.newHealth > 0) {
        	this.player1 = new Ship(this.newHealth);
        	//this.player2 = new Ship(newHealth);
        	if(this.getPlayer1().getPosition().getX() > Constants.SCREEN_WIDTH - (2 * Constants.SHIP_WIDTH) - 120) {
        		Position temp = getPlayer1().getPosition();
        		temp.setX(temp.getX() + ThreadLocalRandom.current().nextInt((int)Constants.SHIP_WIDTH + 5, 100));
        		this.player2 = new Ship(temp);
        	}else {
        		Position temp = getPlayer1().getPosition();
=======
    	if(newHealth > 0) {
        	this.player1 = new Ship(newHealth);
        	//this.player2 = new Ship(newHealth);
        	if(this.getPlayer1().getPosition().getX() > Constants.SCREEN_WIDTH - (2 * Constants.SHIP_WIDTH) - 120) {
        		Position temp = this.getPlayer1().getPosition();
        		temp.setX(temp.getX() + ThreadLocalRandom.current().nextInt((int)Constants.SHIP_WIDTH + 5, 100));
        		this.player2 = new Ship(temp);
        	}else {
        		Position temp = this.getPlayer1().getPosition();
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
        		temp.setX(temp.getX() - ThreadLocalRandom.current().nextInt((int)Constants.SHIP_WIDTH + 5, 100));
        		this.player2 = new Ship(temp);
        	}
    	}else {
        	this.player1 = new Ship();
        	this.player2 = new Ship();
    	}
<<<<<<< HEAD
    	this.missle = new Missle();
    }
    
    public Ship getPlayer1() {
    	return this.player1;
    }
    
    public Ship getPlayer2() {
    	return this.player2;
    }
    
    public boolean getPlayerStatus(){
    	return this.playerStatus;
    }
    
    public Missle getMissle(){
    	return this.missle;
    }
    
    public boolean getWaitTime(){
    	return this.waitTime;
=======
    }
    
    public Ship getPlayer1() {
    	return player1;
    }
    
    public Ship getPlayer2() {
    	return player2;
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
    }
    
    /**
     * Setter fuer beendet. Zum beenden der run-Methode, beendet den Thread
     * @param value boolean, Wert, der in beendet geschrieben werden soll
     */
    public void setBeendet(boolean value){
<<<<<<< HEAD
    	this.beendet = value;
=======
    	beendet = value;
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
    }
    
    public void setNewHealth(int health) {
    	this.newHealth = health;
    }
<<<<<<< HEAD
    
    public void togglePlayerStatus(){
    	this.playerStatus = !this.playerStatus;
    }
    
    public void toggleWaitTime(){
    	this.waitTime = !this.waitTime;
    }
=======
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9

    /**
     * This method is the thread logic.
     */
    public void run() {
    		// update view, d. h. veranlasse das Neuzeichnen des Spielfeldes
<<<<<<< HEAD
    		this.game.notifyObservers();
    		
    		while (!this.beendet) {    			
    			// if ballWasStarted is true (Spiel soll ablaufen, d.h. der Ball soll sich bewegen)
	            if (true) {
=======
    		game.notifyObservers();
    		
    		while (!beendet) {    			
    			// if ballWasStarted is true (Spiel soll ablaufen, d.h. der Ball soll sich bewegen)
	            if (false) {
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
	                
	            	
	                
	                
	                
	                
	                
	                
	                // update view
	            	
<<<<<<< HEAD
	                this.game.notifyObservers();
=======
	                game.notifyObservers();
>>>>>>> 3634986bd50c8ce7d5e97f974af7fb83d54a49c9
	                
	            }
	            // pause thread by a few millis
	            try {
	                Thread.sleep(4);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
    		}   
    }
}