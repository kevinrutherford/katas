using System.Collections.Generic;
using System.IO;
using NUnit.Framework;

namespace ReportGeneratorCS.Tests
{
    [TestFixture]
    public class HtmlReportTest {

        [Test]
        public void testReport() {
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
            HtmlReport.report(output, line, robot);

            string expected = "<h1>FACTORY REPORT</h1>\n"
                              + "<ul>\n<li>Machine mixer</li>\n<li>Machine extruder</li>\n"
                              + "<li>Machine oven bin=chips</li>\n</ul>\n"
                              + "<p>Robot location=extruder bin=paste</p>\n" + "<hr>\n";

            Assert.That(expected, Is.EqualTo(output.ToString()));
        }
    }
}
