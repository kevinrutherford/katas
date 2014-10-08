import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToyotaCorollaTest {

	private Car corolla;

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
		corolla = CarPlant.makeToyotaCorolla();
	}

	@Test
	public void hasTheCorrectName() {
		corolla.turnLeft(27);
		assertEquals("Toyota Corolla", corolla.name());
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
	public void acceleratingOnlyTurnsTheFrontWheels() {
		corolla.accelerate(35);
		assertEquals("front left accelerating 35 kph\n"
				   + "front right accelerating 35 kph\n", CarPlant.LOG);
	}

}
