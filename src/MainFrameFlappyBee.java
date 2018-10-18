import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrameFlappyBee extends JFrame {
	
	//Various fields for my JFrame that were useful
	//All variable names explain their use
	private Component graphicPaint;
	private Timer timer;
	private static int scoreCount = 0;
	private static boolean gameStart = false;
	private static boolean gameOver = false;
	private static long timeStart;
	private static long timeElapsed;

	// Getters
	public static boolean isGameStart() {
		return !gameStart;
	}

	public static boolean isGameEnd() {
		return gameOver;

	}

	public static int getScore() {
		return scoreCount;
	}

	public static long getTime() {
		return timeElapsed;
	}

	public MainFrameFlappyBee() {
		
		//New MyComponent paint
		graphicPaint = new MyComponentPaint();

		add(graphicPaint);
		
		//Timer for my game
		timer = new Timer(25, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Implements repaint and updates my timeElapsed
				//Also continuously implements fall
				if (gameStart && (gameOver == false)) {
					scoreCount++;
					graphicPaint.repaint();
					FlappyAvatar.fall();
					timeElapsed = System.currentTimeMillis() - timeStart;
				}

				// Contains statement for Tubes 1 - 4: intersects
				// Calls the rectangles associated with bird and the obstacle
				// course and causes a game over event.

				if (MyComponentPaint.getTube().getBottomBox().intersects(MyComponentPaint.getBird().getBirdBox())
						|| MyComponentPaint.getTube().getTopBox().intersects(MyComponentPaint.getBird().getBirdBox()) ||
				// Tube 2:
				MyComponentPaint.getTube().getBottomBox2().intersects(MyComponentPaint.getBird().getBirdBox())
						|| MyComponentPaint.getTube().getTopBox2().intersects(MyComponentPaint.getBird().getBirdBox())
						||
				// Tube 3:
				MyComponentPaint.getTube().getTopBox3().intersects(MyComponentPaint.getBird().getBirdBox())
						|| MyComponentPaint.getTube().getBottomBox3()
								.intersects(MyComponentPaint.getBird().getBirdBox())
						||
				// Tube 4:
				MyComponentPaint.getTube().getTopBox4().intersects(MyComponentPaint.getBird().getBirdBox())
						|| MyComponentPaint.getTube().getBottomBox4()
								.intersects(MyComponentPaint.getBird().getBirdBox())) {
					gameOver = true;
				}

				// Checks for intersection of bird and powerup
				if (MyComponentPaint.getBird().getBirdBox().intersects(MyComponentPaint.getPoints().getPowerUp())) {
					scoreCount = scoreCount + 500;
					MyComponentPaint.getPoints().pointUp();
				}
				
				//Checks if bird intersects ground and is not in a pit,
				//if in pit then bird does not trigger gameover event
				if ((MyComponentPaint.getBird().getBirdBox().intersects(MyComponentPaint.getStaticBackground().getGrass())
						|| MyComponentPaint.getBird().getBirdBox().intersects(MyComponentPaint.getStaticBackground().getGround()))
						&& (MyComponentPaint.getTube().getPit().intersects(MyComponentPaint.getBird().getBirdBox()) == false)) {
					gameOver = true;
				}
				
				//Checks if bird intersects ceiling or the pit floor
				//causes gameover event if either is true.
				if(MyComponentPaint.getBird().getBirdBox().intersects(MyComponentPaint.getStaticBackground().getFloor())||
						MyComponentPaint.getBird().getBirdBox().intersects(MyComponentPaint.getStaticBackground().getCeiling())){
					gameOver = true;
				}
				
				//Checks if Power Up spawns on one of the pipes, in case it does it tries to re-spawn it
				
				if (MyComponentPaint.getTube().getBottomBox().intersects(MyComponentPaint.getPoints().getPowerUp())
						|| MyComponentPaint.getTube().getTopBox().intersects(MyComponentPaint.getPoints().getPowerUp()) 
				// Tube 2:
						|| MyComponentPaint.getTube().getBottomBox2().intersects(MyComponentPaint.getPoints().getPowerUp())
						|| MyComponentPaint.getTube().getTopBox2().intersects(MyComponentPaint.getPoints().getPowerUp())
						
				// Tube 3:
						|| MyComponentPaint.getTube().getTopBox3().intersects(MyComponentPaint.getPoints().getPowerUp())
						|| MyComponentPaint.getTube().getBottomBox3().intersects(MyComponentPaint.getPoints().getPowerUp())
				// Tube 4:
						||  MyComponentPaint.getTube().getTopBox4().intersects(MyComponentPaint.getPoints().getPowerUp())
						|| MyComponentPaint.getTube().getBottomBox4().intersects(MyComponentPaint.getPoints().getPowerUp())) {
					MyComponentPaint.getPoints().pointUp();
				}

			}
		});

		timer.start();
		
		//Implemented key listener for both arrow keys
		graphicPaint.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_UP:
					FlappyAvatar.flap();
					break;

				case KeyEvent.VK_DOWN:
					FlappyAvatar.flapDown();
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		});
		
		//Implemented mouselistener for flapping and starting the game
		graphicPaint.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if (gameStart == false) {
					timeStart = System.currentTimeMillis();
				}
				FlappyAvatar.flap();
				gameStart = true;
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

		});

		setVisible(true);
	}

}
