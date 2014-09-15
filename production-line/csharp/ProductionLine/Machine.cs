namespace ProductionLine
{
    class Machine
    {
        private string _name;
        private Bin _bin;
        private string _location;

        internal Machine(string name, string location)
        {
            this._name = name;
            this._location = location;
        }

		internal Bin Take()
        {
            var result = _bin;
            _bin = null;
            return result;
        }

		internal Bin Bin()
        {
            return _bin;
        }

		internal string Location()
        {
            return _location;
        }

		internal void Put(Bin bin)
        {
            this._bin = bin;
        }

		internal string Name()
        {
            return _name;
        }
    }
}
