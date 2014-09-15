using System.Collections.Generic;
using System.IO;
using System.Text;

namespace ProductionLine
{
    class Report
    {
		private IList<Machine> _machines;
		private Robot _robot;
		private ProductionLine _line;

		internal Report(IList<Machine> machines, ProductionLine line, Robot robot)
		{
			_machines = machines;
			_line = line;
			_robot = robot;
		}

		internal string reportTo()
		{
			var result = new StringBuilder();
			result.Append("FACTORY REPORT\n");
			IEnumerator<Machine> line = _machines.GetEnumerator();
			while (line.MoveNext())
			{
				Machine machine = line.Current;
				result.Append("Machine " + machine.Name());
				if (machine.Bin() != null)
					result.Append(" bin=" + machine.Bin());
				result.Append("\n");
			}
			result.Append("\n");
			result.Append("Robot");
			if (_robot.Location() != null)
				result.Append(" location=" + _robot.Location().Name());
			if (_robot.Bin() != null)
				result.Append(" bin=" + _robot.Bin());
			result.Append("\n");
			result.Append("========\n");
			return result.ToString ();
		}
    }
}
