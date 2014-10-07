
abstract class RearWheelDriveCar extends Car
{
  public void Accelerate(double kph)
  {
    _rearLeft.Rotate(kph);
    _rearRight.Rotate(kph);
  }
}