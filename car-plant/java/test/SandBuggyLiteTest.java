import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class SandBuggyLiteTest {

	private Car buggy;

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
		buggy = CarPlant.makeSandBuggyLite();
	}

	@Test
	public void hasTheCorrectName() {
		assertEquals("Sand Buggy Lite", buggy.name());
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
	public void acceleratingTurnsOnlyTheRearWheels() {
		int speed = TestHelpers.randomSpeed();
		buggy.accelerate(speed);
		assertEquals("rear left accelerating " + speed + " kph\n"
				   + "rear right accelerating " + speed + " kph\n", CarPlant.LOG);
	}

}