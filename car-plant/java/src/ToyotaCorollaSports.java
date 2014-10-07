
class ToyotaCorollaSports extends ToyotaCorolla
{
  public void Accelerate(double kph)
  {
     _rearLeft.Rotate(kph);
     _rearRight.Rotate(kph);
  }
}