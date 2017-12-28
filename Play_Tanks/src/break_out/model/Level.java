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
    
    /**
     * Konstante für den Wind, der die Schussbahn verändert
     */
    private int wind;
    
    /**
     * Constant for the health, when a costum health is set
     */
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
        		temp.setX(temp.getX() - ThreadLocalRandom.current().nextInt((int)Constants.SHIP_WIDTH + 5, 100));
        		this.player2 = new Ship(temp);
        	}
    	}else {
        	this.player1 = new Ship();
        	this.player2 = new Ship();
    	}
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
    }
    
    /**
     * Setter fuer beendet. Zum beenden der run-Methode, beendet den Thread
     * @param value boolean, Wert, der in beendet geschrieben werden soll
     */
    public void setBeendet(boolean value){
    	this.beendet = value;
    }
    
    public void setNewHealth(int health) {
    	this.newHealth = health;
    }
    
    public void togglePlayerStatus(){
    	this.playerStatus = !this.playerStatus;
    }
    
    public void toggleWaitTime(){
    	this.waitTime = !this.waitTime;
    }

    /**
     * This method is the thread logic.
     */
    public void run() {
    		// update view, d. h. veranlasse das Neuzeichnen des Spielfeldes
    		this.game.notifyObservers();
    		
    		while (!this.beendet) {    			
    			// if ballWasStarted is true (Spiel soll ablaufen, d.h. der Ball soll sich bewegen)
	            if (true) {
	                
	            	
	                
	                
	                
	                
	                
	                
	                // update view
	            	
	                this.game.notifyObservers();
	                
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