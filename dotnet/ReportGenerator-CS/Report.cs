using System.Collections.Generic;
using System.IO;

namespace ReportGeneratorCS
{
    public class Report
    {
        public static void report(StringWriter output, IList<Machine> machines, Robot robot)
        {
            output.Write("FACTORY REPORT\n");

            IEnumerator<Machine> line = machines.GetEnumerator();
            while (line.MoveNext())
            {
                Machine machine = line.Current;
                output.Write("Machine " + machine.Name());

                if (machine.Bin() != null)
                    output.Write(" bin=" + machine.Bin());

                output.Write("\n");
            }
            output.Write("\n");

            output.Write("Robot");
            if (robot.Location() != null)
                output.Write(" location=" + robot.Location().Name());

            if (robot.Bin() != null)
                output.Write(" bin=" + robot.Bin());

            output.Write("\n");

            output.Write("========\n");
        }
    }
}