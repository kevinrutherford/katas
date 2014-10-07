
abstract class AllWheelDriveCar extends Car
{
  public void Accelerate(double kph)
  {
    _frontLeft.Rotate(kph);
    _frontRight.Rotate(kph);
    _rearLeft.Rotate(kph);
    _rearRight.Rotate(kph);
  }
}