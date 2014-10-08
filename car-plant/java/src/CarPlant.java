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

	public static Car makeSandBuggyLite() {
		return new SandBuggyLite();
	}
}
