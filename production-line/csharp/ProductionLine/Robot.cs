namespace ProductionLine
{
    public class Robot
    {
        private Bin bin;
        private Machine location;

        public Machine Location()
        {
            return location;
        }

        public void MoveTo(Machine location)
        {
            this.location = location;
        }

        public void Pick()
        {
            bin = location.Take();
        }

        public Bin Bin()
        {
            return bin;
        }

        public void Release()
        {
            location.Put(bin);
            bin = null;
        }
    }
}