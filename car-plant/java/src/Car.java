abstract class Car {

	public Wheel _frontLeft;
	public Wheel _frontRight;
	public Wheel _rearLeft;
	public Wheel _rearRight;

	public abstract String name();
	public abstract void accelerate(int kmsPerHour);

	protected Car() {
		_frontLeft = new Wheel("front left");
		_frontRight = new Wheel("front right");
		_rearLeft = new Wheel("rear left");
		_rearRight = new Wheel("rear right");
	}

	public void turnLeft(int degrees) {
		_frontLeft.turnLeft(degrees);
		_frontRight.turnLeft(degrees);
	}

	public void turnRight(int degrees) {
		_frontLeft.turnRight(degrees);
		_frontRight.turnRight(degrees);
	}
}