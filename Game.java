import java.awt.Color;
import java.awt.Graphics2D;
import java.time.Duration;
import java.util.*;

public class Game {
	
	/**********************************************************************************/
	/* Variables and Constants */
	boolean collGreen, collBlue, collRed; 
	ArrayList<redBricks> redbricks;
	ArrayList<greenBricks> greenbricks;
	ArrayList<blueBricks> bluebricks;
	Player player;
	Score score;
	Winner winner;
	Life life;
	Loser loser;
	Balls balls;
	private static final int
							
							/* General */
							Zero = 0,
							bricksQty = 15,
							
							/* Window */
							window_hight = 600,
							window_width = 800,
							
							/* bricks */
							bricksXPos = 53,
							bricksYPos = 22,
							brickXSpace = 3,
							brickYSpace = 2,
							brickWidth = 50,
							brickHeight = 20,
							
							/* Player */
							playerWidth = 200,
							
							/* Balls */
							ballsSize = 24,
							
							/* Score */
							scoreYPost = 300,
							scoreLabelSize = 100;
	
	
	/**********************************************************************************/
	public Game(GameBoard board) {
		
		
		redbricks 	= new ArrayList<redBricks>();
		bluebricks 	= new ArrayList<blueBricks>();
		greenbricks = new ArrayList<greenBricks>();
		
		for(int i= Zero; i < bricksQty ;i++) {
			redbricks.add(new redBricks		(brickXSpace + (bricksXPos * i), brickYSpace				, brickWidth, brickHeight));
			redbricks.add(new redBricks		(brickXSpace + (bricksXPos * i), brickYSpace + bricksYPos 	, brickWidth, brickHeight));
			}
		
		for(int i= Zero; i < bricksQty ;i++) {
			bluebricks.add(new blueBricks	(brickXSpace + (bricksXPos * i), brickYSpace + bricksYPos * 2, brickWidth, brickHeight));
			bluebricks.add(new blueBricks	(brickXSpace + (bricksXPos * i), brickYSpace + bricksYPos * 3, brickWidth, brickHeight));
			}
		for(int i= Zero; i < bricksQty ;i++) {
			greenbricks.add(new greenBricks	(brickXSpace + (bricksXPos * i), brickYSpace + bricksYPos * 4, brickWidth, brickHeight));
			greenbricks.add(new greenBricks	(brickXSpace + (bricksXPos * i), brickYSpace + bricksYPos * 5, brickWidth, brickHeight));
			}
		
		
		player 	= new Player((window_width/2) - playerWidth/2, window_hight - brickWidth, playerWidth, brickHeight);
		balls 	= new Balls	((window_width/2) - (ballsSize / 2) + 2 , window_hight - 70, ballsSize , ballsSize);
		if(balls.getY()==600) {
			
			balls = new Balls	((window_width/2) - (ballsSize / 2) + 2 , window_hight - 70, ballsSize , ballsSize);
		}
		score 	= new Score	(window_width - 75 ,window_hight - 10, scoreLabelSize, scoreLabelSize);
		winner 	= new Winner(window_width/2, scoreYPost);
		life 	= new Life( 5 , window_hight - 10, 10 ,10 );
		loser = new Loser(window_width/2, scoreYPost);
		

		
	}
	
	/************************************** Update ********************************************/
	public void update(Keyboard keyboard) {
		player.update(keyboard);
		balls.update(keyboard);
		
		collGreen 	= false;
		collBlue 	= false;
		collRed 	= false;
		
		for(Bricks brick :greenbricks) {
			
			/*Colliding with green bricks*/
			if(balls.isCollidingGreen(brick)) {
				Score.add(1);
				collGreen 	= true;
			}
		}
		
		for(Bricks brick :bluebricks) {
					
					/*Colliding with blue bricks*/
			if(balls.isCollidingBlue(brick)) {
				Score.add(1);
				collBlue 	= true;
			}
		}
		
		for(Bricks brick :redbricks) {
			
			/*Colliding with red bricks*/
			if(balls.isCollidingRed(brick)) {
				Score.add(1);
				collRed 	= true;
			}
			
			
				if(balls.getY() == 700 && Life.getLifes() == 3) {
					balls.xSpeed = 0;
					balls.ySpeed = 0;
					Life.setLifes();
					
					
					balls.setY(player.getY() - ballsSize);
					balls.setX(player.getX());
					balls.xSpeed = balls.random;
					balls.ySpeed = 10;
				}
				
				if(balls.getY() == 700 && Life.getLifes() == 2) {
					balls.xSpeed = 0;
					balls.ySpeed = 0;
					Life.setLifes();
					balls.setY(player.getY() - ballsSize);
					balls.setX(player.getX());
					balls.xSpeed = balls.random;
					balls.ySpeed = 10;
					
					
				}
				
				if(balls.getY() == 700 && Life.getLifes() == 1) {
					balls.xSpeed = 0;
					balls.ySpeed = 0;
					Life.setLifes();
					balls.setY(player.getY() - ballsSize);
					balls.setX(player.getX());
					balls.xSpeed = balls.random;
					balls.ySpeed = 10;
					
					
				}
				
				if(Life.getLifes() == 0) {
					balls.xSpeed = 0;
					balls.ySpeed = 0;
					
					
					
					
				}
			
				if(Life.getLifes() == 0 || Score.getScore() >= 180) {
					
					highScoreFonster f = new highScoreFonster();
					Latest l = new Latest();
					f.readFile();
					f.order();
					f.writeFile(1);
					f.readFile();
					f.order();
					f.writeFile(0);
					l.readFile();
					l.writeFile(1);
					l.readFile();
					f.khara();
					
					life.addLifes(-1);
				}
				
		}
		
		
		
		/* Action taken if collided */
		Colliding.ifColliding(collGreen, collRed, collBlue, balls, player);
		
		/*Colliding between Player and green bricks*/
		
	}
	/**********************************************************************************/
	
	public void draw(Graphics2D graphics) {
		
		/*********************************** Red *****************************************/
		for(redBricks bricks : redbricks) {
			bricks.draw(graphics);
		}	
		for(int i =0; i < redbricks.size(); i++ ) {
			if(balls.isCollidingRed(redbricks.get(i)) && redbricks.get(i).BrickColor == Color.red) {
				redbricks.get(i).BrickColor = Color.blue;
			}else if(balls.isCollidingRed(redbricks.get(i)) && redbricks.get(i).BrickColor == Color.blue) {
				redbricks.get(i).BrickColor = Color.green;
			}else if(balls.isCollidingRed(redbricks.get(i)) && redbricks.get(i).BrickColor == Color.green ) {
				redbricks.remove(i);
			}

		}
		
		/*********************************** Green ***************************************/
		for(greenBricks bricks : greenbricks) {
				bricks.draw(graphics);
		}
		for(int i =0; i < greenbricks.size(); i++ ) {
			if(balls.isCollidingGreen(greenbricks.get(i))) {
				greenbricks.remove(i);
			}
		}
		
		/************************************ Blue ***************************************/
		for(blueBricks bricks : bluebricks) {
			bricks.draw(graphics);
		}		
		for(int i =0; i < bluebricks.size(); i++ ) {
			if(balls.isCollidingBlue(bluebricks.get(i)) && bluebricks.get(i).BrickColor != Color.green) {
				bluebricks.get(i).BrickColor = Color.green;
			}else if(balls.isCollidingBlue(bluebricks.get(i)) && bluebricks.get(i).BrickColor == Color.green ) {
				bluebricks.remove(i);
			}

		}
		
		
		player.draw(graphics);
		balls.draw(graphics);
		score.draw(graphics);
		winner.draw(graphics);
		loser.draw(graphics);
		life.draw(graphics);
		
		
		
	}
}
