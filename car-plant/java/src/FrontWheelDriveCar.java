abstract class FrontWheelDriveCar extends Car {
	public void Accelerate(int kph) {
		_frontLeft.rotate(kph);
		_frontRight.rotate(kph);
	}
}