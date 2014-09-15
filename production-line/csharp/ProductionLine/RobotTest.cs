using NUnit.Framework;

namespace ProductionLine
{
    [TestFixture]
    public class RobotTest
    {
        [Test]
        public void TestRobot()
        {
            Machine sorter = new Machine("Sorter", "left");
            sorter.Put("chips");
            Machine oven = new Machine("Oven", "middle");
            Robot robot = new Robot();

            Assert.That("chips", Is.EqualTo(sorter.Bin()));
            Assert.That(oven.Bin(), Is.Null);
            Assert.That(robot.Location(), Is.Null);
            Assert.That(robot.Bin(), Is.Null);

            robot.MoveTo(sorter);
            robot.Pick();
            robot.MoveTo(oven);
            robot.Release();

            Assert.That(robot.Bin(), Is.Null);
            Assert.That(oven, Is.EqualTo(robot.Location()));
            Assert.That(sorter.Bin(), Is.Null);
            Assert.That("chips", Is.EqualTo(oven.Bin()));
        }
    }
}