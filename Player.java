import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Sprite {
	
	
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	
	}

	@Override
	public void update(Keyboard keyboard) {
		if(Life.getLifes() > 0 ) {
			if(keyboard.isKeyDown(Key.Right)) {
				if(getX()!= 600) {
					setX(getX()+10);
				}
			}
			if(keyboard.isKeyDown(Key.Left)) {
				if(getX()!= 0) {
					setX(getX()-10);
				}
			}
		}
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.gray);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
		
	}

	public boolean isColliding(Balls balls) {
		Rectangle ballsRect = new Rectangle(balls.getX(), balls.getY(),balls.getWidth(), balls.getHeight() );
		Rectangle playerRect = new Rectangle(getX(), getY(), getWidth(), getHeight() );
		return playerRect.intersects(ballsRect);
	}

}
