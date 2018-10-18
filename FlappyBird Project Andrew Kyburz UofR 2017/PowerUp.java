import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class PowerUp implements ScreenObject {

	private Rectangle point = new Rectangle(600, 200, 20, 20);
	private int deltaX = -2;
	private Random rand = new Random();

	public PowerUp(int xCoordinate,int yCoordinate) {
		point.x = xCoordinate;
		point.y = yCoordinate;
	}
	
	public void update(){
		point.x = point.x + deltaX;
	}
	
	//Method for resetting PowerUp when leaves edge of the screen
	public void reset(){
		if(point.x + point.width < 0){
			point.x = 800;
			point.y = rand.nextInt(430);
		}
	}
	
	//Method for resetting points when bird intersects point box
	public void pointUp(){
		point.x = 800;
		point.y = rand.nextInt(430);
	}

	@Override
	public void paintYourself(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(point.x, point.y, point.width, point.height);
		
		g.setColor(Color.BLACK);
		g.drawRect(point.x, point.y, point.width, point.height);

	}
	
	public Rectangle getPowerUp(){
		return point;
	}

}
