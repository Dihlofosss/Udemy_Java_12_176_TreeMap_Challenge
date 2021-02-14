package com.kostyukov;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList
{
	private final Map<String, StockItem> list;

	public StockList()
	{
		this.list = new HashMap<>();
	}

	public int addStock(StockItem item)
	{
		if (item == null)
			return 0;

		StockItem inStock = list.getOrDefault(item.getName(), item);

		if (inStock != item)
			item.adjustQuantityInStock(inStock.quantityInStock());

		list.put(item.getName(), item);
		return item.quantityInStock();
	}

	public int sellStock(String item, int quantity)
	{
		StockItem inStock = list.getOrDefault(item, null);
		if ((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0))
		{
			inStock.adjustQuantityInStock(-quantity);
			return quantity;
		}
		return 0;
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

			double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

			s = s + ". There are " + stockItem.quantityInStock() + " items in stock. Value of items: ";
			s = s + itemValue + "\n";

			totalCost += itemValue;
		}

		return s + "Total stock value " + totalCost;
	}

}