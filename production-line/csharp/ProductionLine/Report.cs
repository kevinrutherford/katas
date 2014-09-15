using System.Collections.Generic;
using System.IO;

namespace ProductionLine
{
    class Report
    {
		private IList<Machine> _machines;
		private Robot _robot;

		internal Report(IList<Machine> machines, Robot robot)
		{
			_machines = machines;
			_robot = robot;
		}

		internal void reportTo(StringWriter output)
		{
			output.Write("FACTORY REPORT\n");
			IEnumerator<Machine> line = _machines.GetEnumerator();
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
			if (_robot.Location() != null)
				output.Write(" location=" + _robot.Location().Name());
			if (_robot.Bin() != null)
				output.Write(" bin=" + _robot.Bin());
			output.Write("\n");
			output.Write("========\n");
		}
    }
}
