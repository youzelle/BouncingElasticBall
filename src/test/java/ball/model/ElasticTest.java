package ball.model;

import org.junit.jupiter.api.Test;

import static ball.BallTestHarness.*;

public class ElasticTest {
    @Test
    public void shouldDecreaseRadius() {
        Ball elasticBall = BallFactory.elasticBall(0, 0, 20, Elastic.SHRINK);

        elasticBall.update(elasticBall);

        assertRadiusIs(oneStepInwardsFrom(20), elasticBall);
    }

    @Test
    public void shouldIncreaseRadiusAfterFullyShrinking() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, 0, Elastic.SHRINK);

        elasticBall.update(elasticBall);

        assertRadiusIs(oneStepOutwardsFrom(0), elasticBall);
    }

    @Test
    public void shouldIncreaseInSize() {
        Ball elasticBall = BallFactory.elasticBall(250, 100, 20, Elastic.GROW);

        elasticBall.update(elasticBall);

        assertRadiusIs(oneStepOutwardsFrom(20), elasticBall);
    }

    @Test
    public void shouldDecreaseInSizeAfterFullyExpanding() throws Exception {
        Ball elasticBall = BallFactory.elasticBall(0, 0, Ball.DEFAULT_RADIUS, Elastic.GROW);

        elasticBall.update(elasticBall);

        assertRadiusIs(oneStepInwardsFrom(Ball.DEFAULT_RADIUS), elasticBall);
    }

}
