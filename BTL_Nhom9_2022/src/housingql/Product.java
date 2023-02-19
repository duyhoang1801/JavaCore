package housingql;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable
{
	//Constants
	public static final String PRODUCT_ID = "No Name";
	public static final String PRODUCT_NAME = "No Name";
	public static final long PRODUCT_PRICE = 0;
	public static final int PRODUCT_TOTAL = 0;
	
	//Object's properties
	private String product_id;
	private String product_name;
	private long product_price;
	private int product_total;
	
	//Constructor
	public Product() {
		this(Product.PRODUCT_ID, Product.PRODUCT_NAME, Product.PRODUCT_PRICE, Product.PRODUCT_TOTAL);
	}
	
	public Product(String product_id, String product_name, long product_price, int product_total) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}

	
	//Getter and setter method
	public String getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public long getProduct_price() {
		return product_price;
	}

	public int getProduct_total() {
		return product_total;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(long product_price) {
		this.product_price = product_price;
	}

	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}

	
	//toString method
	@Override
	public String toString() {
		return String.format("%-6s %-17s %-13d %-4d", product_id, product_name, product_price, product_total);
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		double a = (this.product_price)/100000;
		double b = (o.product_price)/100000;
		return (int)(a-b);
	}

}
