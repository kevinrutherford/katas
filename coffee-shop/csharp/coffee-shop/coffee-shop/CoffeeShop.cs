using System;
using System.Collections.Generic;

namespace coffeeshop
{
	interface CoffeeOrder
	{
		void serveCoffee (CoffeeOrderContext context);
	}

	class CoffeeFlavor : CoffeeOrder
	{
		private string flavor;

		public CoffeeFlavor (String newFlavor)
		{
			this.flavor = newFlavor;
		}

		public String getFlavor ()
		{
			return this.flavor;
		}

		public void serveCoffee (CoffeeOrderContext context)
		{
			Console.WriteLine ("Serving Coffee flavor " + flavor + " to table number " + context.getTable ());
		}
	}

	class CoffeeOrderContext
	{
		private int tableNumber;

		public CoffeeOrderContext (int tableNumber)
		{
			this.tableNumber = tableNumber;
		}

		public int getTable ()
		{
			return this.tableNumber;
		}
	}

	class CoffeeFlavorFactory
	{
		private Dictionary<string, CoffeeFlavor> flavors = new Dictionary<String, CoffeeFlavor> ();

		public CoffeeFlavor getCoffeeFlavor (String flavorName)
		{
			if (flavors.ContainsKey (flavorName))
				return flavors [flavorName];
			var flavor = new CoffeeFlavor (flavorName);
			flavors.Add (flavorName, flavor);
			return flavor;
		}

		public int getTotalCoffeeFlavorsMade ()
		{
			return flavors.Count;
		}
	}

	class CoffeeShop
	{
		private static CoffeeFlavor[] flavors = new CoffeeFlavor[100];
		private static CoffeeOrderContext[] tables = new CoffeeOrderContext[100];
		private static int ordersMade = 0;
		private static CoffeeFlavorFactory flavorFactory;

		public static void takeOrders (String flavorIn, int table)
		{
			flavors [ordersMade] = flavorFactory.getCoffeeFlavor (flavorIn);
			tables [ordersMade++] = new CoffeeOrderContext (table);
		}

		public static void Main (string[] args)
		{
			flavorFactory = new CoffeeFlavorFactory ();

			takeOrders ("Cappuccino", 2);
			takeOrders ("Cappuccino", 2);
			takeOrders ("Frappe", 1);
			takeOrders ("Frappe", 1);
			takeOrders ("Espresso", 1);
			takeOrders ("Frappe", 897);
			takeOrders ("Cappuccino", 97);
			takeOrders ("Cappuccino", 97);
			takeOrders ("Frappe", 3);
			takeOrders ("Espresso", 3);
			takeOrders ("Cappuccino", 3);
			takeOrders ("Espresso", 96);
			takeOrders ("Frappe", 552);
			takeOrders ("Cappuccino", 121);
			takeOrders ("Espresso", 121);

			for (var i = 0; i < ordersMade; ++i) {
				flavors [i].serveCoffee (tables [i]);
			}
			Console.WriteLine (" ");
			Console.WriteLine ("total CoffeeFlavor objects made: " + flavorFactory.getTotalCoffeeFlavorsMade ());
		}
	}
}
