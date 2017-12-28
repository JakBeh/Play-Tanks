package break_out.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import break_out.Constants;
import break_out.model.Game;
import break_out.model.Level;
import break_out.view.Field;
import break_out.view.StartScreen;
import break_out.view.View;

/**
 * The controller takes care of the input events and reacts on those events by
 * manipulating the view and updates the model.
 * 
 * @author dmlux, modified by I. Schumacher, modified by Jakob Behnke, Ole Engelhardt
 * 
 */
public class Controller implements ActionListener, KeyListener {

    /**
     * The game as model that is connected to this controller
     */
    private Game game;

    /**
     * The view that is connected to this controller
     */
    private View view;

    
    /**
     * The constructor expects a view to construct itself.
     * 
     * @param view The view that is connected to this controller
     */
    public Controller(View view) {
        this.view = view;

        // Assigning the listeners
        assignActionListener();
        assignKeyListener();
    }

    /**
     * The controller gets all buttons out of the view with this method and adds
     * this controller as an action listener. Every time the user pushed a
     * button the action listener (this controller) gets an action event.
     */
    private void assignActionListener() {
        // Get the start screen to add this controller as action
        // listener to the buttons.
        view.getStartScreen().addActionListenerToStartButton(this);
        view.getStartScreen().addActionListenerToQuitButton(this);
    }
    
    /**
     * With this method the controller adds himself as a KeyListener.
     * Every time the user pushed a key the KeyListener (this controller) gets an KeyEvent.
     */
    private void assignKeyListener() {
        // Get the field to add this controller as KeyListener
        view.getField().addKeyListener(this);
    }

    /**
     * Every time the user pushed a button the action listener (this controller) 
     * gets an action event and starts this method
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Getting the start screen
        StartScreen startScreen = view.getStartScreen();
        
        // The 'start game' button was pressed
        if (startScreen.getStartButton().equals(e.getSource())) {
            // Getting the players name from the input
            String playersName = startScreen.getPlayersName();
            playersName = playersName.trim();
            // Getting the players lifes from the input
            String playersLifes = startScreen.getPlayersLifes();
            playersLifes = playersLifes.trim();
            if (playersName.length() < 1) {
                // If the players name is empty it is invalid
                startScreen.showError("Der Name ist ungültig");
            } else {    
            	// Neues Game-Objekt erzeugen und dem View-Objekt bekanntgeben
    	        game = new Game(this);
    	        view.setGame(game);
    	        int health;
    	        
    	        // Falls der Input eine Zahl ist, werden die Leben auf diesen Wert gesetzt
    	        try{
    	        	health = Integer.parseInt(playersLifes);
    	        	game.getLevel().setNewHealth(health);
    	        }catch(NumberFormatException q){
    	        }
            }
        }

        // Der Spieler beendet das Spiel
        else if (startScreen.getQuitButton().equals(e.getSource())) {
            System.exit(0);
        }
    }
 
    /**
     * Methode des KeyListeners
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     * Methode des KeyListeners
     */
    @Override
    public void keyPressed(KeyEvent e) {
    	
    	// Reagiert auf Tastendruck der Leertaste
    	if (e.getKeyCode() == KeyEvent.VK_SPACE){
    		// Starts a shot, regarding the player
    		if(this.game.getLevel().getPlayerStatus() && !this.game.getLevel().getWaitTime()){
    			this.game.getLevel().getMissle().shot(this.game.getLevel().getPlayer1().getPosition(),
    					this.game.getLevel().getPlayer1().getStrength(),
    					this.game.getLevel().getPlayer1().getAngle());
    		}else if(!this.game.getLevel().getPlayerStatus() && !this.game.getLevel().getWaitTime()) {
    			this.game.getLevel().getMissle().shot(this.game.getLevel().getPlayer2().getPosition(),
    					this.game.getLevel().getPlayer2().getStrength(),
    					this.game.getLevel().getPlayer2().getAngle());
    			}
    		this.game.getLevel().togglePlayerStatus();
    		//this.game.getLevel().toggleWaitTime();  //TODO
    	}
    	
    	//Reagiert auf Tastendruck des linken Pfeils, setzt Bewegungsrichtung des Paddles nach links
    	if (e.getKeyCode() == KeyEvent.VK_LEFT){
    		
    	}
    	
    	//Reagiert auf Tastendruck des rechten Pfeils, setzt Bewegungsrichtung des Paddles nach rechts
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT){
    		
    	}
    	
    	if (e.getKeyCode() == KeyEvent.VK_UP){
    		if(this.game.getLevel().getPlayerStatus()){
    			this.game.getLevel().getPlayer1().increaseStrength();
    		}else{
    			this.game.getLevel().getPlayer2().increaseStrength();
    		}
    	}
    	
    	if(e.getKeyCode() == KeyEvent.VK_DOWN){
    		if(this.game.getLevel().getPlayerStatus()){
    			this.game.getLevel().getPlayer1().decreaseStrength();
    		}else{
    			this.game.getLevel().getPlayer2().decreaseStrength();
    		}
    	}
    	
    	//Reagiert auf Tastendruck der Escape-Taste, bricht das Spiel ab
    	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
    		game.getLevel().setBeendet(true);
    		game.getController().toStartScreen();
    	}
    }

    /**
     * Methode des KeyListeners
     */
    @Override
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_LEFT){
    		
    	}
    	
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT){
    		
    	}
    }

    
    /**
     * Mit dieser Methode erfolgt das Umschalten vom Spielfeld zum StartScreen
     */
    public void toStartScreen() {
    	view.showScreen(StartScreen.class.getName());
    	view.getStartScreen().requestFocusInWindow();
    }
    
    /**
     * Ueberladene Methode, um zum Startscreen zu gelangen und den Score anzeigen zu lassen
     * @param score int, enthaelt den Score, der angezeigt werden soll
     */
    public void toStartScreen(int score){
    	view.showScreen(StartScreen.class.getName());
    	view.getStartScreen().requestFocusInWindow();
    	String player = view.getStartScreen().getPlayersName();
    	view.getStartScreen().updateScoreMenu(score, player);
    }
    
    /**
     * Mit dieser Methode erfolgt das Umschalten zum Spielfeld
     */
    public void toPlayground() {
    	view.showScreen(Field.class.getName());
    	view.getField().requestFocusInWindow();
    }   
}
