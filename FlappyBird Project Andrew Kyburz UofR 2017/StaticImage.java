import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public class StaticImage implements ScreenObject {

	// Rectangles for my static image
	private Rectangle sky = new Rectangle(0, 0, 800, 450);
	private Rectangle grass = new Rectangle(0, 450, 800, 10);
	private Rectangle ground = new Rectangle(0, 460, 800, 140);
	private Rectangle sun = new Rectangle(50, 50, 50, 50);
	private Rectangle ceiling = new Rectangle(0,0, 800, 1);
	private Rectangle floor = new Rectangle(0,599,800,1);

	// Arrays for my cloud polygons/Polygon
	private int[] cloud1PointsY = { 40, 30, 40, 30, 40, 60, 50, 40 };
	private int[] cloud1PointsX = { 100, 120, 140, 160, 180, 150, 130, 100 };
	private int[] cloud2PointsY = { 50, 40, 50, 40, 50, 70, 60, 50 };
	private int[] cloud2PointsX = { 300, 320, 340, 360, 380, 350, 330, 300 };
	private int[] cloud3PointsY = { 40, 30, 40, 30, 40, 60, 50, 40 };
	private int[] cloud3PointsX = { 500, 520, 540, 560, 580, 550, 530, 500 };
	private int[] cloud4PointsY = { 50, 40, 50, 40, 50, 70, 60, 50 };
	private int[] cloud4PointsX = { 700, 720, 740, 760, 780, 750, 730, 700 };
	private Polygon cloud;
	
	//Colors for static background
	private Color skyBlue = Color.BLUE.brighter();
	private Color sunYellow = Color.YELLOW;
	private Color grassGreen = Color.GREEN;
	private Color groundBrown = Color.YELLOW.darker().darker();
	
	//Constructor
	public StaticImage() {

	}
	
	//Getters
	public Rectangle getGrass() {
		return grass;
	}

	public Rectangle getGround() {
		return ground;
	}
	
	public Rectangle getFloor(){
		return floor;
	}
	
	public Rectangle getCeiling(){
		return ceiling;
	}

	// Paint Method for static images
	@Override
	public void paintYourself(Graphics g) {
		g.setColor(skyBlue);
		g.fillRect(sky.x, sky.y, sky.width, sky.height);

		g.setColor(sunYellow);
		g.fillOval(sun.x, sun.y, sun.width, sun.height);

		// Paints my clouds
		g.setColor(Color.WHITE);

		cloud = new Polygon(cloud1PointsX, cloud1PointsY, 8);
		g.fillPolygon(cloud);
		cloud = new Polygon(cloud2PointsX, cloud2PointsY, 8);
		g.fillPolygon(cloud);
		cloud = new Polygon(cloud3PointsX, cloud3PointsY, 8);
		g.fillPolygon(cloud);
		cloud = new Polygon(cloud4PointsX, cloud4PointsY, 8);
		g.fillPolygon(cloud);

		g.setColor(groundBrown);
		g.fillRect(ground.x, ground.y, ground.width, ground.height);

		g.setColor(grassGreen);
		g.fillRect(grass.x, grass.y, grass.width, grass.height);

	}

}
