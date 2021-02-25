package com.kostyukov;

public class Main {

	private static StockList stockList = new StockList();
	
	public static void main(String[] args)
	{
		fillStock();
		
		System.out.println(stockList);
		
		Basket myBasket = new Basket("Testing Basket");
		
		sellItem(myBasket, "car", 1);
		System.out.println(myBasket);
		sellItem(myBasket, "car", 1);
		System.out.println(myBasket);
		sellItem(myBasket, "car", 1);
		System.out.println(myBasket);
		
		sellItem(myBasket, "spanner", 2);
		sellItem(myBasket, "juice", 4);
		sellItem(myBasket,"cup", 12);
		sellItem(myBasket,"bread", 5);
		System.out.println(myBasket);
		
		System.out.println(stockList);
	}
	
	public static int sellItem(Basket basket, String item, int quantity)
	{
		StockItem stockItem = stockList.get(item);
		if (stockItem == null)
		{
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (stockList.sellStock(item, quantity) != 0)
		{
			basket.addToBasket(stockItem, quantity);
			return quantity;
		}
		return 0;
	}
	
	public static void fillStock()
	{
		stockList.addStock(new StockItem("bread",	0.86,	100));
		stockList.addStock(new StockItem("cake",	1.10,	7));
		stockList.addStock(new StockItem("car",	12.50,	2));
		stockList.addStock(new StockItem("chair",	62.0,	10));
		
		stockList.addStock(new StockItem("cup",	0.50,	200));
		stockList.addStock(new StockItem("cup",	0.45,	12));
		
		stockList.addStock(new StockItem("door",	72.92,	4));
		stockList.addStock(new StockItem("juice",	2.50,	36));
		stockList.addStock(new StockItem("phone",	96.99,	35));
		stockList.addStock(new StockItem("towel",	2.40,	80));
		stockList.addStock(new StockItem("vase",	8.76,	40));
	}
}