abstract class Car extends BaseCar {
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