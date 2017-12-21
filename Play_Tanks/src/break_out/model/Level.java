package break_out.model;

import break_out.Constants;
import break_out.controller.*;

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
    	this.player1 = new Ship();
    	this.player2 = new Ship();
    }
    
    /**
     * Setter fuer beendet. Zum beenden der run-Methode, beendet den Thread
     * @param value boolean, Wert, der in beendet geschrieben werden soll
     */
    public void setBeendet(boolean value){
    	beendet = value;
    }

    /**
     * This method is the thread logic.
     */
    public void run() {
    		// update view, d. h. veranlasse das Neuzeichnen des Spielfeldes
    		game.notifyObservers();
    		
    		while (!beendet) {    			
    			// if ballWasStarted is true (Spiel soll ablaufen, d.h. der Ball soll sich bewegen)
	            if () {
	                
	            	
	                
	                
	                
	                
	                
	                
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