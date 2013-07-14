namespace ReportGeneratorCS
{
    public class Machine
    {
        private string name;
        private string bin;
        private string location;

        public Machine(string name, string location)
        {
            this.name = name;
            this.location = location;
        }

        public string Take()
        {
            string result = bin;
            bin = null;
            return result;
        }

        public string Bin()
        {
            return bin;
        }

        public string Location()
        {
            return location;
        }

        public void Put(string bin)
        {
            this.bin = bin;
        }

        public string Name()
        {
            return name;
        }
    }
}
