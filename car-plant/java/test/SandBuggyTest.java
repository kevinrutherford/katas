import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class SandBuggyTest {

	private Car buggy;

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
		buggy = CarPlant.makeSandBuggy();
	}

	@Test
	public void hasTheCorrectName() {
		assertEquals("Sand Buggy", buggy.name());
	}

	@Test
	public void turningLeftTurnsAllWheels() {
		int degrees = TestHelpers.randomDegrees();
		buggy.turnLeft(degrees);
		assertEquals("front left turning left " + degrees + " degrees\n"
				   + "front right turning left " + degrees + " degrees\n"
				   + "rear left turning left " + degrees + " degrees\n"
				   + "rear right turning left " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void turningRightTurnsAllWheels() {
		int degrees = TestHelpers.randomDegrees();
		buggy.turnRight(degrees);
		assertEquals("front left turning right " + degrees + " degrees\n"
				   + "front right turning right " + degrees + " degrees\n"
				   + "rear left turning right " + degrees + " degrees\n"
				   + "rear right turning right " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void acceleratingTurnsAllWheels() {
		int speed = TestHelpers.randomSpeed();
		buggy.accelerate(speed);
		assertEquals("front left accelerating " + speed + " kph\n"
				   + "front right accelerating " + speed + " kph\n"
				   + "rear left accelerating " + speed + " kph\n"
				   + "rear right accelerating " + speed + " kph\n", CarPlant.LOG);
	}

}