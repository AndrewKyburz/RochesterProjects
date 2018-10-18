import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainGameMethod {
	
	//Main method for running game
	public static void main(String[] args){
		
		JFrame frame = new MainFrameFlappyBee(); //new MainFrameFlappyBee();
		
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
	}
}
