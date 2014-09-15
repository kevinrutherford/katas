namespace ProductionLine
{
    public class Machine
    {
        private string name;
        private Bin bin;
        private string location;

        public Machine(string name, string location)
        {
            this.name = name;
            this.location = location;
        }

        public Bin Take()
        {
            var result = bin;
            bin = null;
            return result;
        }

        public Bin Bin()
        {
            return bin;
        }

        public string Location()
        {
            return location;
        }

        public void Put(Bin bin)
        {
            this.bin = bin;
        }

        public string Name()
        {
            return name;
        }
    }
}
