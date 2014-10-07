abstract class FrontWheelDriveCar extends Car {
	public void accelerate(int kph) {
		_frontLeft.rotate(kph);
		_frontRight.rotate(kph);
	}
}