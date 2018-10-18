import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class MyComponentPaint extends JComponent {

	private static StaticImage staticBackground;
	private static FlappyAvatar bird;
	private static ObstacleTube tube1;
	private static PowerUp points;
	private Font score = new Font("Score", Font.PLAIN, 18);

	public MyComponentPaint() {

		staticBackground = new StaticImage();
		tube1 = new ObstacleTube(100, 120, 80);
		bird = new FlappyAvatar();
		points = new PowerUp(400, 300);

		setFocusable(true);
	}

	// Paint component for game
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// paints static part of background
		staticBackground.paintYourself(g);

		// Prints start text, prompts user for mouse click
		if (MainFrameFlappyBee.isGameStart()) {
			g.setFont(score);
			g.setColor(Color.WHITE);
			g.drawString("Please click to start!", 300, 300);
		}

		// Updates point box location

		points.reset();
		points.paintYourself(g);
		points.update();

		// Updates tube obstacle course location
		tube1.resetTubeEnd();
		tube1.paintYourself(g);
		tube1.update();

		// Updates bird location
		bird.paintYourself(g);
		bird.update();

		// Draws score and time in respective corners
		g.setFont(score);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + MainFrameFlappyBee.getScore(), 10, 20);
		g.drawString("Time: " + MainFrameFlappyBee.getTime() / 1000 + " s", 600, 20);

		// Prints game over message and score
		if (MainFrameFlappyBee.isGameEnd()) {
			g.setFont(score);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER! FINAL SCORE: " + MainFrameFlappyBee.getScore(), 300, 300);
		}

	}

	// Methods for returning specific screen elements
	public static FlappyAvatar getBird() {
		return bird;
	}

	public static ObstacleTube getTube() {
		return tube1;
	}

	public static PowerUp getPoints() {
		return points;
	}

	public static StaticImage getStaticBackground() {
		return staticBackground;
	}

}
