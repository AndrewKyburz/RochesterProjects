import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ObstacleTube implements ScreenObject {
	
	//Obstacle course consists of 9 rectangles(8 tubes and 1 pit)
	private Rectangle topBox;
	private Rectangle bottomBox;
	private Rectangle topBox2;
	private Rectangle bottomBox2;
	private Rectangle topBox3;
	private Rectangle bottomBox3;
	private Rectangle topBox4;
	private Rectangle bottomBox4;
	private Rectangle pit;

	private static Color color = Color.GREEN.darker();
	private int deltaX = -2;
	
	//Constructor for tube course
	public ObstacleTube(int tubeHeight, int tubeGap, int tubeWidth) {

		topBox = new Rectangle(800, 0, tubeWidth , tubeHeight);
		bottomBox = new Rectangle(800, tubeHeight + tubeGap, tubeWidth, 450 - tubeHeight - tubeGap);
		
		tubeHeight = 300;
		topBox2 = new Rectangle(1000, 0, tubeWidth , tubeHeight);
		bottomBox2 = new Rectangle(1000, tubeHeight + tubeGap, tubeWidth , 450 - tubeHeight - tubeGap);
		
		tubeHeight = 120;
		topBox3 = new Rectangle(1200, 0, tubeWidth , tubeHeight);
		bottomBox3 = new Rectangle(1200, tubeHeight + tubeGap, tubeWidth, 450 - tubeHeight - tubeGap);
		
		tubeHeight = 200;
		topBox4 = new Rectangle(1400, 0, tubeWidth, tubeHeight);
		bottomBox4 = new Rectangle(1400, tubeHeight + tubeGap, tubeWidth, 450 - tubeHeight - tubeGap);
		
		pit = new Rectangle(1100,450,tubeWidth,150);

	}
	
	//Method for checking tube end of 4th box, largely for development reasons
	public int getTubeEnd() {
		return topBox4.x + topBox4.width;

	}
	
	//Method for resetting each tube as it goes off the left hand side of the screen
	public void resetTubeEnd() {
		
		if(topBox.x + topBox.width < 0){	
		topBox.x = 800;
		bottomBox.x = 800;
		}else if(topBox2.x + topBox2.width<0){
		topBox2.x = 800;
		bottomBox2.x = 800;
		}else if(topBox3.x + topBox3.width<0){
		topBox3.x = 800;
		bottomBox3.x = 800;
		}else if(topBox4.x + topBox4.width<0){
		topBox4.x = 800;
		bottomBox4.x = 800;
		}else if(pit.x + pit.width<0){
			pit.x = 800;
		}

	}
	
	//Update method for tubes
	public void update() {

		topBox.x += deltaX;
		bottomBox.x += deltaX;

		topBox2.x += deltaX;
		bottomBox2.x += deltaX;

		topBox3.x += deltaX;
		bottomBox3.x += deltaX;

		topBox4.x += deltaX;
		bottomBox4.x += deltaX;
		
		pit.x += deltaX;

	}
	
	//Paint method
	@Override
	public void paintYourself(Graphics g) {

		g.setColor(color);

		g.fillRect(topBox.x, topBox.y, topBox.width, topBox.height);
		g.fillRect(bottomBox.x, bottomBox.y, bottomBox.width, bottomBox.height);

		g.fillRect(topBox2.x, topBox2.y, topBox2.width, topBox2.height);
		g.fillRect(bottomBox2.x, bottomBox2.y, bottomBox2.width, bottomBox2.height);

		g.fillRect(topBox3.x, topBox3.y, topBox3.width, topBox3.height);
		g.fillRect(bottomBox3.x, bottomBox3.y, bottomBox3.width, bottomBox3.height);

		g.fillRect(topBox4.x, topBox4.y, topBox4.width, topBox4.height);
		g.fillRect(bottomBox4.x, bottomBox4.y, bottomBox4.width, bottomBox4.height);
		
		g.setColor(Color.BLUE);
		g.fillRect(pit.x, pit.y, pit.width, pit.height);

	}

	// Getters for tube rectangles

	public Rectangle getTopBox() {
		return topBox;
	}

	public Rectangle getBottomBox() {
		return bottomBox;
	}

	public Rectangle getTopBox2() {
		return topBox2;
	}

	public Rectangle getBottomBox2() {
		return bottomBox2;
	}

	public Rectangle getTopBox3() {
		return topBox3;
	}

	public Rectangle getBottomBox3() {
		return bottomBox3;
	}

	public Rectangle getTopBox4() {
		return topBox4;
	}

	public Rectangle getBottomBox4() {
		return bottomBox4;
	}
	
	public Rectangle getPit(){
		return pit;
	}

}
