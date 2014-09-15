using System;

namespace ProductionLine
{
	public class Bin
	{
		private string _contents;

		internal Bin (string contents)
		{
			_contents = contents;
		}

		internal string Contents ()
		{
			return _contents;
		}
	}
}

