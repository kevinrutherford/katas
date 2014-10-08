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
		corolla.turnLeft(27);
		assertEquals("Toyota Corolla sports", corolla.name());
	}

	@Test
	public void turningLeftOnlyTurnsTheFrontWheels() {
		corolla.turnLeft(27);
		assertEquals("front left turning left 27 degrees\n"
				   + "front right turning left 27 degrees\n", CarPlant.LOG);
	}

	@Test
	public void turningRightOnlyTurnsTheFrontWheels() {
		corolla.turnRight(15);
		assertEquals("front left turning right 15 degrees\n"
				   + "front right turning right 15 degrees\n", CarPlant.LOG);
	}

	@Test
	public void acceleratingOnlyTurnsTheRearWheels() {
		corolla.accelerate(35);
		assertEquals("rear left accelerating 35 kph\n"
				   + "rear right accelerating 35 kph\n", CarPlant.LOG);
	}

}