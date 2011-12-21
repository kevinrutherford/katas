using System.Collections.Generic;
using System.IO;

namespace ReportGeneratorCS
{
    public class HtmlReport
    {
        public static void report(StringWriter output, IList<Machine> machines, Robot robot)
        {
            output.Write("<h1>FACTORY REPORT</h1>\n");

            IEnumerator<Machine> line = machines.GetEnumerator();
            output.Write("<ul>\n");
            while (line.MoveNext())
            {
                Machine machine = line.Current;
                output.Write("<li>");
                output.Write("Machine " + machine.Name());

                if (machine.Bin() != null)
                    output.Write(" bin=" + machine.Bin());

                output.Write("</li>\n");
            }
            output.Write("</ul>\n");

            output.Write("<p>");
            output.Write("Robot");
            if (robot.Location() != null)
                output.Write(" location=" + robot.Location().Name());

            if (robot.Bin() != null)
                output.Write(" bin=" + robot.Bin());

            output.Write("</p>\n");

            output.Write("<hr>\n");
        }
    }
}