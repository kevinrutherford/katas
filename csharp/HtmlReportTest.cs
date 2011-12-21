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
                              + "<h2>mixer</h2>\n"
                              + "<ul>\n"
                              + "<li>location = left</li>\n"
                              + "<li>no bin</li>\n"
                              + "</ul>\n"
                              + "<h2>extruder</h2>\n"
                              + "<ul>\n"
                              + "<li>location = center</li>\n"
                              + "<li>no bin</li>\n"
                              + "</ul>\n"
                              + "<h2>oven</h2>\n"
                              + "<ul>\n"
                              + "<li>location = right</li>\n"
                              + "<li>bin containing chips</li>\n"
                              + "</ul>\n"
                              + "<h2>Robot</h2>\n"
                              + "<ul>\n"
                              + "<li>location = extruder</li>\n"
                              + "<li>bin containing paste</li>\n"
                              + "</ul>\n";

            Assert.That(expected, Is.EqualTo(output.ToString()));
        }
    }
}
