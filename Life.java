import java.awt.Color;
import java.awt.Graphics2D;

public class Life extends Sprite{
	private static int lifes = 3;
	
	public static int getLifes() {
		return lifes;
	}
	
	public static void setLifes() {
		lifes -= 1; 
	}	
	
	public static void addLifes(int x) {
		lifes = x; 
	}	
	public Life(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	@Override
	public void update(Keyboard keyboard) {

		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.red);
		graphics.drawString("You have " + getLifes() + " lifes left", getX(), getY());
		
	}



}
