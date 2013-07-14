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
            while (line.MoveNext())
            {
                Machine machine = line.Current;
                output.Write("<h2>" + machine.Name() + "</h2>\n");
                output.Write("<ul>\n");
                output.Write("<li>location = " + machine.Location() + "</li>\n");

                if (machine.Bin() != null)
                    output.Write("<li>bin containing " + machine.Bin() + "</li>\n");
                else
                    output.Write("<li>no bin</li>\n");

                output.Write("</ul>\n");
            }

            output.Write("<h2>Robot</h2>\n<ul>\n");
            if (robot.Location() != null)
                output.Write("<li>location = " + robot.Location().Name() + "</li>\n");

            if (robot.Bin() != null)
                output.Write("<li>bin containing " + robot.Bin() + "</li>\n");

            output.Write("</ul>\n");
        }
    }
}
