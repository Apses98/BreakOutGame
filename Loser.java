import java.awt.Color;
import java.awt.Graphics2D;

public class Loser extends Sprite{

	public Loser(int x, int y) {
		super(x, y, 0, 0);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(Life.getLifes() <= 0) {
			graphics.setColor(Color.red);
			graphics.drawString("Game Over!!!", getX(), getY());
			
		}
		
	}

}
