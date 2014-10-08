public class CarPlant {
	public static String LOG;

	public static Car makeToyotaCorolla() {
		return new ToyotaCorolla();
	}

	public static Car makeToyotaCorollaSports() {
		return new ToyotaCorollaSports();
	}

	public static Car makeMitsubishiTriton() {
		return new MitsubishiTriton();
	}

	public static Car makeSandBuggy() {
		return new SandBuggy();
	}
}

// Finally, the customer comes along and asks us to model for them a new
// experimental
// four wheel drive buggy that is designed to go on sand and turns with all four
// wheels.
// A two wheel drive buggy is also available (it also turns with all four
// wheels).
