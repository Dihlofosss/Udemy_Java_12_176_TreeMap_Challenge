package com.kostyukov;

public class StockItem implements Comparable<StockItem>
{
	private final String name;
	private double price;
	private int quantityInStock;

	public StockItem(String name, double price)
	{
		this(name, price,0);
	}

	public StockItem(String name, double price, int quantityInStock)
	{
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public int quantityInStock()
	{
		return quantityInStock;
	}

	public void setPrice(double price)
	{
		if (price > 0.0)
			this.price = price;
	}

	public void adjustQuantityInStock(int quantity)
	{
		int newQuantity = this.quantityInStock + quantity;
		if (newQuantity >= 0 )
			this.quantityInStock = newQuantity;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj == null || obj.getClass() != this.getClass())
			return false;

		String objName = ((StockItem) obj).getName();

		return objName.equals(this.getName());
	}

	@Override
	public int hashCode()
	{
		return this.name.hashCode() + 41;
	}

	@Override
	public int compareTo(StockItem o)
	{
		if (this == o)
			return 0;

		if (o != null)
			return this.getName().compareTo(o.getName());

		throw new NullPointerException();
	}

	@Override
	public String toString()
	{
		return this.name + " price: " + this.price;
	}
}