using System.Collections.Generic;
using System.IO;
using NUnit.Framework;

namespace ProductionLine
{
    [TestFixture]
    public class ReportTest
    {
        [Test]
        public void TestReport()
        {
			var p = new ProductionLine();
			p.AddMachine("mixer", "left");

            Machine extruder = p.AddMachine("extruder", "center");
            extruder.Put(new Bin("paste"));

            Machine oven = p.AddMachine("oven", "right");
            oven.Put(new Bin("chips"));

            Robot robot = new Robot();
            robot.MoveTo(extruder);
            robot.Pick();

            var output = new Report(p, robot).report();

            string expected = "FACTORY REPORT\n"
                              + "Machine mixer\nMachine extruder\n"
                              + "Machine oven bin=chips\n\n"
                              + "Robot location=extruder bin=paste\n" + "========\n";

            Assert.That(expected, Is.EqualTo(output));
        }
    }
}
