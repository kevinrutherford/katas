using System;
using System.Collections.Generic;

namespace ProductionLine
{
	class ProductionLine
	{
		private IList<Machine> _machines = new List<Machine>();

		internal ProductionLine ()
		{
		}

		internal Machine AddMachine (string name, string location)
		{
			var machine = new Machine (name, location);
			_machines.Add (machine);
			return machine;
		}

		internal void EachMachine (Action<Machine> f)
		{
			foreach (var machine in _machines)
				f (machine);
		}
	}
}

