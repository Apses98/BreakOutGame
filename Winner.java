import java.awt.*;

public class Winner extends Sprite{

	public Winner(int x, int y) {
		super(x, y, 0, 0);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(Score.getScore() == 180) {
			graphics.setColor(Color.red);
			graphics.drawString("You Won!!!", getX(), getY());
			
		}
		
	}

}
