package break_out.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import break_out.Constants;
import net.miginfocom.swing.MigLayout;

/**
 * The field represents the board of the game. All components are on the board
 * 
 * @author dmlux, modified by iSchumacher, modified by Jakob Behnke, Ole Engelhardt
 * 
 */
public class Field extends JPanel {

	/**
	 * Automatic generated serial version UID
	 */
	private static final long serialVersionUID = 2434478741721823327L;

	/**
	 * The connected view object
	 */
	private View view;

	/**
	 * The background color
	 */
	private Color background;

	/**
	 * The constructor needs a view
	 * 
	 * @param view The view of this board
	 */
	public Field(View view) {
		super();

		this.view = view;
		this.background = new Color(177, 92, 107);

		setFocusable(true);

		// Load settings
		initialize();
	}

	/**
	 * Initializes the settings for the board
	 */
	private void initialize() {
		// creates a layout
		setLayout(new MigLayout("", "0[grow, fill]0", "0[grow, fill]0"));
	}

	/**
	 * Change the background color
	 * @param color The new color
	 */
	public void changeBackground(Color color) {
		background = color;
		repaint();
	}
	
	/**
	 * Die Methode wird zum Zeichnen / Neuzeichnen des Spielfeldes aufgerufen, dazu werden z. B. Hintergrundfarbe, Ballfarbe usw.
	 * angegeben und die einzelnen Methoden zum Zeichnen wie drawBall(g2) aufgerufen.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		double w = Constants.SCREEN_WIDTH;
		double h = Constants.SCREEN_HEIGHT;

		// Die Abmessungen des Spielfeldes bestimmen
		setPreferredSize(new Dimension((int) w, (int) h));
		setMaximumSize(new Dimension((int) w, (int) h));
		setMinimumSize(new Dimension((int) w, (int) h));

		// Die Schaerfe der Zeichnung festlegen
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		// Die Hintergrundfarbe setzen
		g2.setColor(background);
		g2.fillRect(0, 0, getWidth(), getHeight());
		
		// Die Ballfarbe setzen
		g2.setColor(new Color(200, 200, 200));
		
		// Spieler 1 zeichnen
		drawPlayer1(g2);
		
		// Spieler 2 zeichnen
		drawPlayer2(g2);
		
		// Das Leben von Spieler 1 zeichnen
		drawLifesPlayer1(g2);
		
		// Das Leben von Spieler 2 zeichnen
		drawLifesPlayer2(g2);
		
	}
	
	private void drawPlayer1(Graphics2D g2) {
		g2.fillRect((int)view.getGame().getLevel().getPlayer1().getPosition().getX(),
				(int)view.getGame().getLevel().getPlayer1().getPosition().getY(),
				(int)Constants.SHIP_WIDTH,
				(int)Constants.SHIP_HEIGHT);
	}
	
	private void drawPlayer2(Graphics2D g2) {
		g2.fillRect((int)view.getGame().getLevel().getPlayer2().getPosition().getX(),
				(int)view.getGame().getLevel().getPlayer2().getPosition().getY(),
				(int)Constants.SHIP_WIDTH,
				(int)Constants.SHIP_HEIGHT);
	}
	
	/**
	 * Methode zum Zeichnen der Leben von Spieler 1
	 * @param g2 Graphics2D, Darstellung des Hintergrundes
	 */
	private void drawLifesPlayer1(Graphics g2){
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		g2.setColor(Color.BLUE);
		g2.setFont(font);
		g2.drawString("Leben: "+ view.getGame().getLevel().getPlayer1().getHealth(), (int)Constants.SCREEN_WIDTH - 100, 20);
	}
	
	/**
	 * Methode zum Zeichnen der Leben von Spieler 2
	 * @param g2 Graphics2D, Darstellung des Hintergrundes
	 */
	private void drawLifesPlayer2(Graphics g2){
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		g2.setColor(Color.BLUE);
		g2.setFont(font);
		g2.drawString("Leben: "+ view.getGame().getLevel().getPlayer2().getHealth(), (int)Constants.SCREEN_WIDTH - 100, 20);
	}
}