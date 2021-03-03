package com.kostyukov;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList
{
	private final Map<String, StockItem> list;

	public StockList()
	{
		this.list = new LinkedHashMap<>();
	}

	public int addStock(StockItem item)
	{
		if (item == null)
			return 0;

		StockItem inStock = list.getOrDefault(item.getName(), item);

		if (inStock != item)
			item.adjustQuantityInStock(inStock.availableQuantity());

		list.put(item.getName(), item);
		return item.availableQuantity();
	}
	
	public int reserveStock(String item, int quantity)
	{
		StockItem stockItem = list.get(item);
		
		if (stockItem != null && quantity > 0)
			return stockItem.reserveInStock(quantity);
		
		return 0;
	}
	
	public int unreserveStock(String name, int quantity)
	{
		StockItem stockItem = list.get(name);
		
		if (stockItem != null && quantity <= stockItem.getReservedInStock() && quantity > 0)
			return stockItem.unreserveInStock(quantity);
		
		return 0;
	}

	public int sellStock(String item, int quantity)
	{
		StockItem stockItem = list.get(item);
		
		if (stockItem != null && quantity > 0)
		{
			return stockItem.finalizeStock(quantity);
		}
		
		return 0;
		
//		StockItem inStock = list.getOrDefault(item, null);
//		if ((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0))
//		{
//			inStock.adjustQuantityInStock(-quantity);
//			return quantity;
//		}
//		return 0;
	}

	public StockItem get(String key)
	{
		return list.get(key);
	}

	public Map<String, StockItem> Items()
	{
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString()
	{
		String s = "\nStock List\n";
		double totalCost = 0.0;
		for (Map.Entry<String, StockItem> item : list.entrySet())
		{
			StockItem stockItem = item.getValue();

			double itemValue = stockItem.getPrice() * stockItem.availableQuantity();

			s = s + stockItem + ". There are " + stockItem.availableQuantity() + " items in stock. Value of items: ";
			s = s + String.format("%.2f",itemValue) + "\n";

			totalCost += itemValue;
		}

		return s + "Total stock value " + totalCost;
	}

}