package ball;

import ball.model.Ball;
import ball.model.Bouncing;
import ball.model.Elastic;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTestHarness {

    public static void assertCenterYCoordinateIs(int expectedCenterY, Ball ball) {
        assertEquals(expectedCenterY, ball.center().y, "Ball is at the wrong y-coordinate!");
    }

    public static int oneStepDownFrom(int centerY) {
        return centerY + Bouncing.MOVEMENT_SPEED;
    }

    public static int oneStepUpFrom(int centerY) {
        return centerY - Bouncing.MOVEMENT_SPEED;
    }


    public static void assertRadiusIs(int expectedRadius, Ball ball) {
        assertEquals(expectedRadius, ball.radius(), "Ball does not have the correct radius");
    }

    public static int oneStepInwardsFrom(int radius) {
        return radius - Elastic.GROWTH_RATE;
    }

    public static int oneStepOutwardsFrom(int radius) {
        return radius + Elastic.GROWTH_RATE;
    }
}
