abstract class RearWheelDriveCar extends Car {
	public void Accelerate(int kph) {
		_rearLeft.rotate(kph);
		_rearRight.rotate(kph);
	}
}