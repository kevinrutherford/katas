
abstract class Car extends BaseCar
{
  protected Car() {
    _frontLeft = new Wheel();
    _frontRight = new Wheel();
    _rearLeft = new Wheel();
    _rearRight = new Wheel();
  }

  public void TurnLeft(double degrees)
  {
    _frontLeft.TurnLeft(degrees);
    _frontRight.TurnLeft(degrees);
  }

  public void TurnRight(double degrees)
  {
    _frontRight.TurnRight(degrees);
    _frontLeft.TurnRight(degrees);
  }

  public void Accelerate(double kph)
  {
    _frontLeft.Rotate(kph);
    _frontRight.Rotate(kph);
  }
}