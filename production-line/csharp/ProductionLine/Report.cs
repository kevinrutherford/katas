using System.IO;
using System.Text;

namespace ProductionLine
{
    class Report
    {
		private Robot _robot;
		private ProductionLine _line;

		internal Report(ProductionLine line, Robot robot)
		{
			_line = line;
			_robot = robot;
		}

		internal string report()
		{
			var result = new StringBuilder();
			result.Append("FACTORY REPORT\n");
			ReporMachines (result);
			result.Append ("\n");
			ReportRobot (result);
			result.Append("========\n");
			return result.ToString ();
		}

		void ReporMachines (StringBuilder result)
		{
			_line.EachMachine (machine => ReportMachine(machine, result));
		}

		private void ReportMachine (Machine machine, StringBuilder result)
		{
			result.Append ("Machine " + machine.Name ());
			if (machine.Bin () != null)
				result.Append (" bin=" + machine.Bin ());
			result.Append ("\n");
		}

		private void ReportRobot (StringBuilder result)
		{
			result.Append ("Robot");
			if (_robot.Location () != null)
				result.Append (" location=" + _robot.Location ().Name ());
			if (_robot.Bin () != null)
				result.Append (" bin=" + _robot.Bin ());
			result.Append ("\n");
		}
    }
}
