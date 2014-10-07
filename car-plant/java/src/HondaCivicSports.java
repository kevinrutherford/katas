class HondaCivicSports extends RearWheelDriveCar {
	public void Accelerate(int kph) {
		_rearLeft.rotate(kph);
		_rearRight.rotate(kph);
	}
}