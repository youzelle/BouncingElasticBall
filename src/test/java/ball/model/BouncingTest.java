package ball.model;

import ball.ui.BallWorld;
import org.junit.jupiter.api.Test;

import static ball.BallTestHarness.*;

public class BouncingTest {
    @Test
    public void shouldGoDown() {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, Bouncing.DOWN);

        bouncingBall.update(bouncingBall);

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingBall);
    }

    @Test
    public void shouldGoUpAfterHittingTheBottom() throws Exception {
        int theBottomEdge = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theBottomEdge, Bouncing.DOWN);

        bouncingBall.update(bouncingBall);

        assertCenterYCoordinateIs(oneStepUpFrom(theBottomEdge), bouncingBall);
    }

    @Test
    public void shouldGoUp() throws Exception {
        Ball bouncingBall = BallFactory.bouncingBall(0, 100, Bouncing.UP);

        bouncingBall.update(bouncingBall);

        assertCenterYCoordinateIs(oneStepUpFrom(100), bouncingBall);
    }

    @Test
    public void shouldGoDownAfterHittingTheTop() throws Exception {
        int theTopEdge = Ball.DEFAULT_RADIUS;
        Ball bouncingBall = BallFactory.bouncingBall(0, theTopEdge, Bouncing.UP);

        bouncingBall.update(bouncingBall);

        assertCenterYCoordinateIs(oneStepDownFrom(theTopEdge), bouncingBall);
    }
}
