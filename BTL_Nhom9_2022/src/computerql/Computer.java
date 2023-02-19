package computerql;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class Computer extends Product implements Serializable {
	public static final String CONFIG =  "No config";
	public static final int MANUFACTURE_YEAR = 0;
	
	private String config;
	private int manufacture_year;
	
	public Computer() {
		this(Computer.PRODUCT_ID, Computer.PRODUCT_NAME, Computer.PRODUCT_PRICE, Computer.PRODUCT_TOTAL, Computer.CONFIG, Computer.MANUFACTURE_YEAR);
	}
	public Computer(int product_id, String product_name, double product_price, int product_total, String config, int manufacture_year) {
		super(product_id, product_name, product_price, product_total);
		this.config = config;
		this.manufacture_year = manufacture_year;
	}

	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public int getManufacture_year() {
		return manufacture_year;
	}
	public void setManufacture_year(int manufacture_year) {
		this.manufacture_year = manufacture_year;
	}
	@Override
	public String toString() {
		return " Computer ["+super.toString() + ", config =" + config + ", manufacture_year ="
				+ manufacture_year + "]";
	}
	
	public boolean delComputer(Computer c) {
		for (Computer com : ComputerGUI.list) {
			if (com.equals(c)) {
				ComputerGUI.list.remove(c);
				return true;
			}
		}
		return false;
	}
	public List<Computer> searchComputer(String name) {
		List<Computer> com = new ArrayList<>();
		name = name.toLowerCase();
		for (Computer c : ComputerGUI.list) {
			if (c.getProduct_name().toLowerCase().contains(name))
				com.add(c);
		}
		return com;
	}
	public List<Computer> searchComputer(double price) {
		List<Computer> com = new ArrayList<>();
		for (Computer c : ComputerGUI.list) {
			if (c.getProduct_price() == price)
				com.add(c);
		}
		return com;
	}
	public List<Computer> searchComputerbyConfig(String config) {
		List<Computer> com = new ArrayList<>();
		for (Computer c : ComputerGUI.list) {
			if (c.getConfig().compareToIgnoreCase(config) == 0)
				com.add(c);
		}
		return com;
	}
	public List<Computer> searchComputerbyYear(int year) {
		List<Computer> com = new ArrayList<>();
		for (Computer c : ComputerGUI.list) {
			if (c.getManufacture_year() == year)
				com.add(c);
		}
		return com;
	}
	public static List<Computer> generatedComputer(int n) {
		String[] configName = {"RTX 2080", "RTX 2070", "Radeon RX 5700", "RTX 2060", "Radeon RX 5800", "RTX 3080", "RTX 3090"
};
		Computer[] list = new Computer[n];
		List<Computer> com = Arrays.asList(list);
		for(int i = 0; i < n; i++) {
			list[i] = new Computer();
			int indexConfig = (int) (Math.random() * configName.length);
			list[i].setProduct_id(100 + i + 1);
			list[i].setProduct_name("Computer" + (int)(Math.random() * 50));
			list[i].setProduct_price((int)(5000000 + (int)(Math.random()*5000000)));
			list[i].setProduct_total(1 + (int)(Math.random()*20));
			list[i].setConfig(configName[indexConfig]);
			list[i].setManufacture_year(2016 + (int)(Math.random()*6));	
		}
		return com;
	}
}

