import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.Color;

public class FlappyAvatar implements ScreenObject {

	private Rectangle bird;
	private static int deltaY = 0;
	private static int fallCounter = 0;
	private static Color birdColor = Color.YELLOW;

	// Constructor for flappy bird avatar
	public FlappyAvatar() {
		bird = new Rectangle(240, 225, 20, 20);
	}

	public void update() {
		bird.y = bird.y + deltaY;
	}

	// Method for implementing gravity
	public static void fall() {

		if (fallCounter < 15) {
			fallCounter++;
		}

		if (fallCounter > 5) {
			deltaY = fallCounter;
		}

	}

	// Methods for controlling the movement of bird by setting deltaY
	public static void flap() {
		deltaY = -6;
		fallCounter = 0;
	}

	public static void flapDown() {
		deltaY = 7;
	}

	// Paint yourself method
	@Override
	public void paintYourself(Graphics g) {

		g.setColor(birdColor);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);

		g.setColor(Color.BLACK);
		g.drawRect(bird.x, bird.y, bird.width, bird.height);

	}

	// Method for returning rectangle associated with avatar
	public Rectangle getBirdBox() {

		return bird;
	}

}
