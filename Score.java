import java.awt.Color;
import java.awt.Graphics2D;

public class Score extends Sprite {
	private static int points = 0;
	
	public static int getScore() {
		return points; 
	}
	
	public static void add(int addedpoints) {
		points += addedpoints; 
	}
	
	public Score(int x, int y, int width, int height) {
		super(x, y, width, height);
	
	}


	@Override
	public void update(Keyboard keyboard) {
	
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(points != 180 ) {
			graphics.setColor(Color.red);
			graphics.drawString("Score: " + getScore(), getX(), getY());
		}
	}

}
