using System;
using System.Collections.Generic;

namespace ProductionLine
{
	public class ProductionLine
	{
		private IList<Machine> _machines = new List<Machine>();

		public ProductionLine ()
		{
		}

		public Machine AddMachine (string name, string location)
		{
			var machine = new Machine (name, location);
			_machines.Add (machine);
			return machine;
		}
	}
}

