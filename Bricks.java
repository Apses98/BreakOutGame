import java.awt.Color;
import java.awt.Graphics2D;

public class Bricks extends Sprite  {
	Color BrickColor;
	public Bricks(int x, int y, int width, int height,Color color) {
		super(x, y, width, height);
		BrickColor = color;
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(BrickColor);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
