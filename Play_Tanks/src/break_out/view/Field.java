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
		
		// Das Paddle zeichnen
		drawPaddle(g2);
		
		// Das Raster zeichnen
		drawGrid(g2);
		
		// Die Steine zeichnen
		drawStones(g2);
		
		// Den Score zeichnen
		drawScore(g2);
		
		// Die Leben zeichnen
		drawLifes(g2);
		
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
	 * Zeichnet das Paddle, greift dabei ueber das ihm bekannte view-Objekt auf das zugehoerige Game-Objekt und
	 * darueber auf das Level-Objekt zu, um dortige Methoden zu nutzen
	 * @param g2
	 */
	private void drawPaddle(Graphics2D g2){
		g2.fillRoundRect((int) view.getGame().getLevel().getPaddle().getPosition().getX(),
				(int) view.getGame().getLevel().getPaddle().getPosition().getY(),
				(int) Constants.PADDLE_WIDTH,
				(int) Constants.PADDLE_HEIGHT,
				(int) 5,
				(int) 5);
	}
	
	/**
	 * Methode zum Zeichnen der Lienien im Hintergrund
	 * @param g2 Graphics2D, Darstellung des Hintergrundes
	 */
	private void drawGrid(Graphics2D g2){
		for(int i = 0; i <= Constants.SQUARES_X; i++){
			g2.drawLine (
				(int) i*((int)Constants.SCREEN_WIDTH)/Constants.SQUARES_X, 
				(int) 0, 
				(int) i*((int)Constants.SCREEN_WIDTH)/Constants.SQUARES_X, 
				(int) Constants.SCREEN_HEIGHT);
		}
		for(int i = 0; i <= Constants.SQUARES_Y; i++){
			g2.drawLine(
				(int) 0, 
				(int) i*((int)Constants.SCREEN_HEIGHT)/Constants.SQUARES_Y, 
				(int) Constants.SCREEN_WIDTH, 
				(int) i*((int)Constants.SCREEN_HEIGHT)/Constants.SQUARES_Y);
		}
	}
	
	/**
	 * Methode zum Zeichnen der Steine
	 * @param g2 Graphics2D, Darstellung des Bildes
	 */
	private void drawStones(Graphics2D g2){
		//Einbinden des Level-Musters
		int[][] steine = view.getGame().getLevel().getSteineMatrix();
		
		for(int i = 0; i < Constants.SQUARES_X; i++){
			for(int j = 0; j < Constants.SQUARES_Y; j++){
				//Abfrage ob Stein gezeichnet werden soll, entsprechende Farbe, je nach Wert
				switch(steine[j][i]){
				
				// Weiss bei 1
				case 1: steine[j][i] = 1;
					g2.setColor(Color.white);
					g2.fillRect(i * ((int)Constants.SCREEN_WIDTH/Constants.SQUARES_X)+2,
							j * ((int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y)+2,
							(int)Constants.SCREEN_WIDTH/Constants.SQUARES_X-3,
							(int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y-3);
					break;
				
				// Gelb bei 2
				case 2: steine[j][i] = 2;
					g2.setColor(Color.yellow);
					g2.fillRect(i * ((int)Constants.SCREEN_WIDTH/Constants.SQUARES_X)+2,
							j * ((int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y)+2,
							(int)Constants.SCREEN_WIDTH/Constants.SQUARES_X-3,
							(int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y-3);
					break;
				
				// Orange bei 3
				case 3: steine[j][i] = 3;
					g2.setColor(Color.orange);
					g2.fillRect(i * ((int)Constants.SCREEN_WIDTH/Constants.SQUARES_X)+2,
							j * ((int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y)+2,
							(int)Constants.SCREEN_WIDTH/Constants.SQUARES_X-3,
							(int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y-3);
					break;
				
				// Rot bei 4
				case 4: steine[j][i] = 4;
					g2.setColor(Color.red);
					g2.fillRect(i * ((int)Constants.SCREEN_WIDTH/Constants.SQUARES_X)+2,
							j * ((int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y)+2,
							(int)Constants.SCREEN_WIDTH/Constants.SQUARES_X-3,
							(int)Constants.SCREEN_HEIGHT/Constants.SQUARES_Y-3);
					break;
				
				default:
					break;
				
				}
			}
		}
	}
	
	/**
	 * Methode zum Zeichnen des Scores
	 * @param g2 Graphics2D, Darstellung des Hintergrundes
	 */
	private void drawScore(Graphics g2){
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		g2.setColor(Color.blue);
		g2.setFont(font);
		g2.drawString("Score: "+ view.getGame().getLevel().getScore(), 10, 20);
	}
	
	/**
	 * Methode zum Zeichnen der Leben
	 * @param g2 Graphics2D, Darstellung des Hintergrundes
	 */
	private void drawLifes(Graphics g2){
		Font font = new Font("Arial", Font.PLAIN, 20);
		
		g2.setColor(Color.BLUE);
		g2.setFont(font);
		g2.drawString("Leben: "+ view.getGame().getLevel().getLifes(), (int)Constants.SCREEN_WIDTH - 100, 20);
	}
}