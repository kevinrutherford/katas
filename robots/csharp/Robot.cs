namespace ReportGeneratorCS
{
    public class Robot
    {
        private string bin;
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

        public string Bin()
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