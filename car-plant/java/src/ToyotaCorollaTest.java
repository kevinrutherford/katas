import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ToyotaCorollaTest {

	@Before
	public void setUp() throws Exception {
		CarPlant.LOG = "";
	}

	@Test
	public void turningLeftOnlyTurnsTheFrontWheels() {
		ToyotaCorolla corolla = new ToyotaCorolla();
		corolla.turnLeft(27);
		assertEquals(CarPlant.LOG, "front left turning left 27 degrees\n"
								 + "front right turning left 27 degrees\n");
	}

	@Test
	public void turningRightOnlyTurnsTheFrontWheels() {
		ToyotaCorolla corolla = new ToyotaCorolla();
		corolla.turnRight(15);
		assertEquals(CarPlant.LOG, "front left turning right 15 degrees\n"
								 + "front right turning right 15 degrees\n");
	}

}
