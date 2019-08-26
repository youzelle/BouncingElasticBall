package ball.model;

import java.util.ArrayList;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50,Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                // bouncingElasticBall() --> Let's make a new ball!
        };
    }

    public static Ball bouncingBall(int x, int y, int direction) {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        Behaviour bounce = new Bouncing(direction);
        behaviours.add(bounce);
        return new Ball(x, y, behaviours);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        Behaviour shrink = new Elastic(direction);
        behaviours.add(shrink);
        return new Ball(centerX, centerY, radius, behaviours);
    }
}
