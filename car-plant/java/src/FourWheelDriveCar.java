abstract class FourWheelDriveCar extends Car {
	public void accelerate(int kph) {
		_frontLeft.rotate(kph);
		_frontRight.rotate(kph);
		_rearLeft.rotate(kph);
		_rearRight.rotate(kph);
	}
}