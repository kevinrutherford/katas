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
	public void turningLeftOnlyTurnsTheFrontWheels() {
		corolla.turnLeft(27);
		assertEquals(CarPlant.LOG, "front left turning left 27 degrees\n"
								 + "front right turning left 27 degrees\n");
	}

	@Test
	public void turningRightOnlyTurnsTheFrontWheels() {
		corolla.turnRight(15);
		assertEquals(CarPlant.LOG, "front left turning right 15 degrees\n"
								 + "front right turning right 15 degrees\n");
	}

}
