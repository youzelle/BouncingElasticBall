package ball.model;

import java.util.ArrayList;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[] {
            bouncingBall(75, 50,Bouncing.DOWN),
            elasticBall(300, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
            bouncingElasticBall(550, 550, Ball.DEFAULT_RADIUS, Elastic.SHRINK, Bouncing.DOWN)
        };
    }

    public static Ball bouncingBall(int x, int y, int bounceDirection) {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        Behaviour bounce = new Bouncing(bounceDirection);
        behaviours.add(bounce);
        return new Ball(x, y, behaviours);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int growthDirection) {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        Behaviour shrink = new Elastic(growthDirection);
        behaviours.add(shrink);
        return new Ball(centerX, centerY, radius, behaviours);
    }

    public static Ball bouncingElasticBall(int x, int y, int radius, int growthDirection, int bounceDirection) {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        Behaviour shrink = new Elastic(growthDirection);
        Behaviour bounce = new Bouncing(bounceDirection);
        behaviours.add(bounce);
        behaviours.add(shrink);
        return new Ball(x, y, radius, behaviours);
    }
}
