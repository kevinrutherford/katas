import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ToyotaCorollaSportsTest {

	private Car corolla;

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
		corolla = CarPlant.makeToyotaCorollaSports();
	}

	@Test
	public void hasTheCorrectName() {
		assertEquals("Toyota Corolla sports", corolla.name());
	}

	@Test
	public void turningLeftOnlyTurnsTheFrontWheels() {
		int degrees = TestHelpers.randomDegrees();
		corolla.turnLeft(degrees);
		assertEquals("front left turning left " + degrees + " degrees\n"
				   + "front right turning left " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void turningRightOnlyTurnsTheFrontWheels() {
		int degrees = TestHelpers.randomDegrees();
		corolla.turnRight(degrees);
		assertEquals("front left turning right " + degrees + " degrees\n"
				   + "front right turning right " + degrees + " degrees\n", CarPlant.LOG);
	}

	@Test
	public void acceleratingOnlyTurnsTheRearWheels() {
		int speed = TestHelpers.randomSpeed();
		corolla.accelerate(speed);
		assertEquals("rear left accelerating " + speed + " kph\n"
				   + "rear right accelerating " + speed + " kph\n", CarPlant.LOG);
	}

}