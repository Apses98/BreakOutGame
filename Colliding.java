
public class Colliding {
	
	


	public static void ifColliding(boolean collGreen, boolean collRed, boolean collBlue, Balls balls, Player player ) {
		
		if(collGreen){
			balls.ySpeed *= -1;
		}else if(collBlue){
			
			balls.ySpeed *= -1;
		}else if(collRed){
			
			balls.ySpeed *= -1;
		}
		
	
		if(player.isColliding(balls)) {
			balls.ySpeed*=-1;
			
		}
	}
	
	
}
