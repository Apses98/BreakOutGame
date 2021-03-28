import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Balls extends Sprite {
	Random rand = new Random();
	public int random = rand.nextInt(20);
	public static final int borderL = 0, borderR = 770, borderU = 0, borderD = 576;
	public int xSpeed = 3;
	public int ySpeed = 5;
	public boolean lostLife = false;
	
	public Balls(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void update(Keyboard keyboard) {
		
		setY(getY() - ySpeed);
		setX(getX() - xSpeed);

		
		if(getY() < borderU ) {
			setY(0);
		}
		if(getX() < borderL) {
			setX(0);
		}
		if(getX() > borderR) {
			setX(borderR);
		}
		if(getY() > borderD) {
			setY(700);
		}
		
		



		
		
		
		if( getY() == borderU ) {
			ySpeed *= -1;
		}
		if( getX() == borderL || getX() == borderR ) {
			xSpeed *= -1;
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.pink);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
		if(Score.getScore() == 180) {
			xSpeed = 0 ;
			ySpeed = 0 ;
		}
	}
	
	/**************************************************  Is Colliding for bricks  *******************************************************/
	/* Green */
	public boolean isCollidingGreen(Bricks greenbricks) {
		Rectangle ballsRect = new Rectangle(getX(), getY(),getWidth(), getHeight() );
		Rectangle bricksRect = new Rectangle(greenbricks.getX(), greenbricks.getY(), greenbricks.getWidth(), greenbricks.getHeight() );
		return ballsRect.intersects(bricksRect);
	}
	/* Blue */
	public boolean isCollidingBlue(Bricks bluebricks) {
		Rectangle ballsRect = new Rectangle(getX(), getY(),getWidth(), getHeight() );
		Rectangle bricksRect = new Rectangle(bluebricks.getX(), bluebricks.getY(), bluebricks.getWidth(), bluebricks.getHeight() );
		return ballsRect.intersects(bricksRect);
	}
	/* Red */
	public boolean isCollidingRed(Bricks redbricks) {
		Rectangle ballsRect = new Rectangle(getX(), getY(),getWidth(), getHeight() );
		Rectangle bricksRect = new Rectangle(redbricks.getX(), redbricks.getY(), redbricks.getWidth(), redbricks.getHeight() );
		return ballsRect.intersects(bricksRect);
	}
	
}
