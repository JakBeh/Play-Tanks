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
    
    /**
     * Konstante für den Wind, der die Schussbahn verändert
     */
    private int wind;
    
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
    	this.wind = ThreadLocalRandom.current().nextInt(-20, 21);
    	this.newHealth = 0;
    	if(newHealth > 0) {
        	this.player1 = new Ship(newHealth);
        	this.player2 = new Ship(newHealth);
    	}else {
        	this.player1 = new Ship();
        	this.player2 = new Ship();
    	}
    }
    
    public Ship getPlayer1() {
    	return player1;
    }
    
    public Ship getPlayer2() {
    	return player2;
    }
    
    /**
     * Setter fuer beendet. Zum beenden der run-Methode, beendet den Thread
     * @param value boolean, Wert, der in beendet geschrieben werden soll
     */
    public void setBeendet(boolean value){
    	beendet = value;
    }
    
    public void setNewHealth(int health) {
    	this.newHealth = health;
    }

    /**
     * This method is the thread logic.
     */
    public void run() {
    		// update view, d. h. veranlasse das Neuzeichnen des Spielfeldes
    		game.notifyObservers();
    		
    		while (!beendet) {    			
    			// if ballWasStarted is true (Spiel soll ablaufen, d.h. der Ball soll sich bewegen)
	            if (false) {
	                
	            	
	                
	                
	                
	                
	                
	                
	                // update view
	            	
	                game.notifyObservers();
	                
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