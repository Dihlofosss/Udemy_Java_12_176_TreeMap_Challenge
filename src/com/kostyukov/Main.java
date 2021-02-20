package com.kostyukov;

public class Main {

	private static StockList stockList = new StockList();
	
	public static void main(String[] args)
	{
		stockList.addStock(new StockItem("bread", 0.86, 100));
		stockList.addStock(new StockItem("cake", 1.10, 7));
		stockList.addStock(new StockItem("car", 12.50, 2));
		stockList.addStock(new StockItem("chair", 62.0, 10));
		stockList.addStock(new StockItem("cup", 0.50, 200));
		stockList.addStock(new StockItem("door", 72.92, 4));
		stockList.addStock(new StockItem("juice", 2.50, 36));
		stockList.addStock(new StockItem("phone", 96.99, 35));
		stockList.addStock(new StockItem("towel", 2.40, 80));
		stockList.addStock(new StockItem("vase", 8.76, 40));
		
		System.out.println(stockList);
		
		
		
	}
}