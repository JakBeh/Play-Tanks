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
    	        int lifes;
    	        
    	        // Falls der Input eine Zahl ist, werden die Leben auf diesen Wert gesetzt
    	        try{
    	        	lifes = Integer.parseInt(playersLifes);
    	        	game.getLevel().setLifes(lifes);
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
    		// Pausiert das Spiel, falls es laeuft
    		if(game.getLevel().ballWasStarted() == true){
    			game.getLevel().stopBall();
    		}
    		// Startet das Spiel, falss es nicht laeuft
    		else{
    			game.getLevel().startBall();
    		}
    	}
    	
    	//Reagiert auf Tastendruck des linken Pfeils, setzt Bewegungsrichtung des Paddles nach links
    	if (e.getKeyCode() == KeyEvent.VK_LEFT){
    		game.getLevel().getPaddle().setDirection(-1);
    	}
    	
    	//Reagiert auf Tastendruck des rechten Pfeils, setzt Bewegungsrichtung des Paddles nach rechts
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT){
    		game.getLevel().getPaddle().setDirection(1);
    	}
    	
    	//Reagiert auf Tastendruck der Escape-Taste, bricht das Spiel ab
    	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
    		game.getLevel().setBeendet(true);
    		game.getController().toStartScreen(game.getLevel().getScore());
    	}
    	
    	//Reagiert auf Tastendruck der F12-Taste, startet/beendet den Paddle-Cheat
    	if(e.getKeyCode() == KeyEvent.VK_F12){
    		game.getLevel().toggleCheat();
    	}
    }

    /**
     * Methode des KeyListeners
     */
    @Override
    public void keyReleased(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_LEFT){
    		game.getLevel().getPaddle().setDirection(0);
    	}
    	
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT){
    		game.getLevel().getPaddle().setDirection(0);
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
