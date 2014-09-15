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
            IList<Machine> line = new List<Machine>();
            line.Add(new Machine("mixer", "left"));

            Machine extruder = new Machine("extruder", "center");
            extruder.Put("paste");
            line.Add(extruder);

            Machine oven = new Machine("oven", "right");
            oven.Put("chips");
            line.Add(oven);

            Robot robot = new Robot();
            robot.MoveTo(extruder);
            robot.Pick();

            StringWriter output = new StringWriter();
            Report.report(output, line, robot);

            string expected = "FACTORY REPORT\n"
                              + "Machine mixer\nMachine extruder\n"
                              + "Machine oven bin=chips\n\n"
                              + "Robot location=extruder bin=paste\n" + "========\n";

            Assert.That(expected, Is.EqualTo(output.ToString()));
        }
    }
}