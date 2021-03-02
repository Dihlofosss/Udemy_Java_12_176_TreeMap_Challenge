package com.kostyukov;

public class StockItem implements Comparable<StockItem>
{
	private final String name;
	private double price;
	private int quantityInStock;
	private int reserved;

	public StockItem(String name, double price)
	{
		this(name, price,0);
	}

	public StockItem(String name, double price, int quantityInStock)
	{
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.reserved = 0;
	}
	
	public int getReservedInStock()
	{
		return reserved;
	}
	
	public int reserveInStock(int amountToReserve)
	{
		if (amountToReserve <= 0)
			return 0;
		
		else if (amountToReserve > availableQuantity())
		{
			System.out.println("You reserving " + amountToReserve + " items of " + name + ", but only " + (quantityInStock - reserved) + " is available");
			return 0;
		}
		else
			return reserved += amountToReserve;
	}
	
	public int unreserveInStock(int amountToUnreserve)
	{
		if (amountToUnreserve <= 0 || amountToUnreserve > reserved)
		{
			System.out.println("Invalid unreserving amount");
			return 0;
		}
		
		else
			return reserved -= amountToUnreserve;
	}
	
	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public int availableQuantity()
	{
		return quantityInStock - reserved;
	}

	public void setPrice(double price)
	{
		if (price > 0.0)
			this.price = price;
	}

	public void adjustQuantityInStock(int quantity)
	{
		int newQuantity = quantityInStock + quantity;
		if (newQuantity >= 0 )
			quantityInStock = newQuantity;
	}
	
	public int finalizeStock(int quantity)
	{
		if (quantity <= reserved)
		{
			quantityInStock -= quantity;
			reserved -= quantity;
			return quantity;
		}
		
		return 0;
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
		return this.name + " price: " + this.price + ". Reserved: " + this.reserved;
	}
}