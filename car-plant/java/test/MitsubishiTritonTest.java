import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MitsubishiTritonTest {

	private Car triton;

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
		triton = CarPlant.makeMitsubishiTriton();
	}

	@Test
	public void hasTheCorrectName() {
		assertEquals("Mitsubishi Triton", triton.name());
	}

	@Test
	public void turningLeftOnlyTurnsTheFrontWheels() {
		int degrees = TestHelpers.randomDegrees();
		triton.turnLeft(degrees);
		assertEquals("front left turning left " + degrees + " degrees\n"
				   + "front right turning left " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void turningRightOnlyTurnsTheFrontWheels() {
		int degrees = TestHelpers.randomDegrees();
		triton.turnRight(degrees);
		assertEquals("front left turning right " + degrees + " degrees\n"
				   + "front right turning right " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void acceleratingTurnsAllWheels() {
		int speed = TestHelpers.randomSpeed();
		triton.accelerate(speed);
		assertEquals("front left accelerating " + speed + " kph\n"
				   + "front right accelerating " + speed + " kph\n"
				   + "rear left accelerating " + speed + " kph\n"
				   + "rear right accelerating " + speed + " kph\n", CarPlant.LOG);
	}

}