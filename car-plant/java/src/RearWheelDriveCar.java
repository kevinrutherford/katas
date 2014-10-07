abstract class RearWheelDriveCar extends Car {
	public void accelerate(int kph) {
		_rearLeft.rotate(kph);
		_rearRight.rotate(kph);
	}
}