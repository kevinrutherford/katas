
abstract class FrontWheelDriveCar extends Car
{
  public void Accelerate(double kph)
  {
    _frontLeft.Rotate(kph);
    _frontRight.Rotate(kph);
  }
}