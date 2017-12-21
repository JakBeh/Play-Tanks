package break_out.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import break_out.Constants;
import net.miginfocom.swing.MigLayout;

/**
 * This screen serves the configuration of the game.
 * 
 * @author dmlux, modified by I. Schumacher, modified by Jakob Behnke, Ole Engelhardt
 * 
 */
public class StartScreen extends JPanel {

	/**
	 * Automatic generated serial version UID
	 */
	private static final long serialVersionUID = -131505828069382345L;

	/**
	 * Start game button
	 */
	private JButton startGame;

	/**
	 * The connected view object
	 */
	private View view;

	/**
	 * Quit game button
	 */
	private JButton quitGame;

	/**
	 * Input field for the players name
	 */
	private JTextField playersName;

	/**
	 * The error label
	 */
	private JLabel error;
	
	/**
	 * Label fuer den Score,
	 * extern erzeugt, damit Inhalt (Spielername und Score)
	 * von aussen geaendert werden koennen
	 */
	private JLabel score;
	
	/**
	 * Eingabefeld fuer die Leben
	 */
	private JTextField playersLifes;

	
	/**
	 * The constructor needs a view
	 * 
	 * @param view The view of this board
	 */
	public StartScreen(View view) {
		super();
		this.view = view;
		double w = Constants.SCREEN_WIDTH;
		double h = Constants.SCREEN_HEIGHT;

		setPreferredSize(new Dimension((int) w, (int) h));
		setMaximumSize(new Dimension((int) w, (int) h));
		setMinimumSize(new Dimension((int) w, (int) h));

		initialize();
	}

	
	/**
	 * Initializes the settings for this screen
	 */
	private void initialize() {
		// layout
		setLayout(new MigLayout("",
				"10[35%, center, grow, fill][65%, center, grow, fill]10",
				"10[center, grow, fill]10"));

		// background color
		setBackground(Constants.BACKGROUND);

		// initializes menu
		initializeLeftMenu();
		initializeScoreMenu();
	}

	/**
	 * Initializes the left menu
	 */
	private void initializeLeftMenu() {
		// the layout
		SectionPanel leftMenu = new SectionPanel();
		leftMenu.shady = false;
		leftMenu.setLayout(new MigLayout("", "10[center, grow, fill]10",
				"10[center]30[center]5[center]20[center]5[center]0"));

		// adding components to the layout
		startGame = new JButton("Spiel starten");
		quitGame = new JButton("Spiel beenden");
		playersName = new JTextField();
		playersLifes = new JTextField();

		error = new JLabel("");
		error.setForeground(new Color(204, 0, 0));
		error.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel menuLabel = new JLabel(Constants.APP_TITLE + " Spielmenü");
		menuLabel.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);

		leftMenu.add(menuLabel, "cell 0 0, growx");
		leftMenu.add(new JLabel("Spielername:"), "cell 0 1, growx, gapleft 5");
		leftMenu.add(playersName, "cell 0 2, growx");
		leftMenu.add(new JLabel("Leben (Optional, ansonst Standard)"), "cell 0 3, growx");
		leftMenu.add(playersLifes, "cell 0 4, growx");
		leftMenu.add(startGame, "cell 0 5, growx");
		leftMenu.add(quitGame, "cell 0 6, growx");
		leftMenu.add(error, "cell 0 7, growx");
		add(leftMenu, "cell 0 0");
	}

	/**
	 * Initializes the right menu
	 */
	private void initializeScoreMenu() {
		// The layout
		SectionPanel scoreMenu = new SectionPanel(Color.WHITE);
		scoreMenu.shady = false;
		scoreMenu.setLayout(new MigLayout("", "10[center, grow, fill]10",
				"5[center]5"));

		// adding the compoenents to the layout
		JLabel headline = new JLabel("Scores");
		headline.setFont(new Font("Sans-serif", Font.PLAIN, 16));
		headline.setHorizontalAlignment(SwingConstants.CENTER);
		scoreMenu.add(headline, "cell 0 0, gaptop 5");
		
		score = new JLabel("");
		score.setHorizontalAlignment(SwingConstants.CENTER);
		scoreMenu.add(score, "cell 0 1, gaptop 5");
		
		add(scoreMenu, "cell 1 0, gapleft 5");
	}

	/**
	 * Adds an action listener to the start button
	 */
	public void addActionListenerToStartButton(ActionListener l) {
		startGame.addActionListener(l);
	}

	/**
	 * Returns the start button
	 * @return startGame The button for starting the game
	 */
	public JButton getStartButton() {
		return startGame;
	}

	/**
	 * Adds an action listener to the quit button
	 */
	public void addActionListenerToQuitButton(ActionListener l) {
		quitGame.addActionListener(l);
	}

	/**
	 * Returns the quit button
	 * @return quitGame The button for ending the game
	 */
	public JButton getQuitButton() {
		return quitGame;
	}

	/**
	 * Returns the players name
	 * @return The name of the player in the JTextField playersName
	 */
	public String getPlayersName() {
		return playersName.getText();
	}
	
	/**
	 * Getter fuer das Textfeld "playersLifes"
	 * @return String, Inhalt von "playersLifes"
	 */
	public String getPlayersLifes(){
		return playersLifes.getText();
	}

	/**
	 * Shows an error in the menu
	 * @param message The String to be shown
	 */
	public void showError(String message) {
		error.setText(message);
	}

	/**
	 * Removes error message from the screen
	 */
	public void hideError() {
		error.setText("");
	}
	
	/**
	 * Methode, um den Score im JLabel zu aktualisieren
	 * @param score, int, der den aktuellen Score speichert
	 * @param player, String der den Namen des aktuellen Spielers enthaelt
	 */
	public void updateScoreMenu(int score, String player){
		this.score.setText(player + ": "+score);
		
	}
	
}
