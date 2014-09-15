namespace ProductionLine
{
    class Robot
    {
        private Bin _bin;
        private Machine _location;

        internal Machine Location()
        {
            return _location;
        }

		internal void MoveTo(Machine location)
        {
            this._location = location;
        }

		internal void Pick()
        {
            _bin = _location.Take();
        }

		internal Bin Bin()
        {
            return _bin;
        }

		internal void Release()
        {
            _location.Put(_bin);
            _bin = null;
        }
    }
}
