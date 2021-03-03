package com.kostyukov;

import java.util.Map;

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
		
		sellItem(myBasket,"spanner", 2);
		sellItem(myBasket,"juice", 4);
		sellItem(myBasket,"cup", 12);
		sellItem(myBasket,"bread", 10);
//		System.out.println(myBasket);
		
//		System.out.println(stockList);
		
		Basket basket = new Basket("Customer");
		
		sellItem(basket, "cup", 100);
		sellItem(basket, "juice", 5);
		removeItem(basket, "cup", 1);
		System.out.println(basket);
		
		removeItem(myBasket, "car", 1);
		removeItem(myBasket, "cup", 9);
		removeItem(myBasket, "car", 1);
		System.out.println("cars removed: " + removeItem(myBasket, "car", 1));
		
		System.out.println(myBasket);
		
		removeItem(myBasket,"juice", 4);
		removeItem(myBasket,"cup", 3);
		removeItem(myBasket,"bread", 10);
		
		System.out.println(myBasket);
		
		System.out.println("\nDisplay stock list before and after checkout");
		System.out.println(basket);
		System.out.println(stockList);
		checkOut(basket);
		System.out.println(basket);
		System.out.println(stockList);
		
		checkOut(myBasket);
		System.out.println(myBasket);
		System.out.println(basket);
		
		
	}
	
	public static int sellItem(Basket basket, String item, int quantity)
	{
		StockItem stockItem = stockList.get(item);
		if (stockItem == null)
		{
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (stockList.reserveStock(item, quantity) != 0)
		{
			return basket.addToBasket(stockItem, quantity);
		}
		return 0;
	}
	
	public static void checkOut(Basket basket)
	{
		for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet())
		{
			stockList.sellStock(item.getKey().getName(), item.getValue());
		}
		basket.emptyBasket();
	}
	
	public static int removeItem(Basket basket, String item, int quantity)
	{
		StockItem stockItem = stockList.get(item);
		if (stockItem == null)
		{
			System.out.println("We don't sell " + item);
			return 0;
		}
		
		if (basket.removeFromBasket(stockItem, quantity) == quantity)
		{
			return stockList.unreserveStock(item, quantity);
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