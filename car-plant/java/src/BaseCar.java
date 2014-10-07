abstract class BaseCar {
	public Wheel _frontLeft;
	public Wheel _frontRight;
	public Wheel _rearLeft;
	public Wheel _rearRight;
	public String log;

	public abstract String name();
	public abstract void turnLeft(int degrees);
	public abstract void turnRight(int degrees);
	public abstract void accelerate(int kmsPerHour);
}