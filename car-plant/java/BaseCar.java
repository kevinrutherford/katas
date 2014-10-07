
abstract class BaseCar
{
  public Wheel _frontLeft;
  public Wheel _frontRight;
  public Wheel _rearLeft;
  public Wheel _rearRight;
  public String Manufacturer;

  public abstract void TurnLeft(double degrees);
  public abstract void TurnRight(double degrees);
  public abstract void Accelerate(double kmsPerHour);
}