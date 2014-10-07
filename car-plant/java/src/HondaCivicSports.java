
class HondaCivicSports extends RearWheelDriveCar
{
  public void Accelerate(double kph)
  {
     _rearLeft.Rotate(kph);
     _rearRight.Rotate(kph);
  }
}