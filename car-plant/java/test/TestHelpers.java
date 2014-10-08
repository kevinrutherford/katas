import java.util.Random;

public class TestHelpers {
	private static Random rand = new Random();

	public static int randomDegrees() {
		return rand.nextInt(50) + 1;
	}

	public static int randomSpeed() {
		return rand.nextInt(80) + 5;
	}

}
