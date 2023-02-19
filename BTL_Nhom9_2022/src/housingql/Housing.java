package housingql;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

import menuquanly.Statistic;
import menuquanly.TypeStatic;






public class Housing extends Product{
	static Housing h = new Housing();
	public static Scanner sc = new Scanner(System.in);
	static List<Housing> list = new ArrayList<>();
	
	//Constants
	public static final double HOUSING_AREA = 0;
	public static final String HOUSING_TYPE = "No Name";
	
	//Object's properties
	private double housing_area;
	private String housing_type;
	
	//Constructor method
	public Housing() {
		this(Housing.PRODUCT_ID, Housing.PRODUCT_NAME, Housing.PRODUCT_PRICE, Housing.PRODUCT_TOTAL, Housing.HOUSING_AREA, Housing.HOUSING_TYPE);
	}
	
	public Housing(String product_id, String product_name, long product_price, int product_total, double housing_area, String housing_type) {
		//Khởi tạo đối tượng cha Product
		super(product_id, product_name, product_price, product_total);
		
		//Xác định dữ liệu đối tượng con
		this.housing_area = housing_area;
		this.housing_type = housing_type;
	}
	
	//getter and setter
	public double getHousing_area() {
		return housing_area;
	}

	public String getHousing_type() {
		return housing_type;
	}

	public void setHousing_area(double housing_area) {
		this.housing_area = housing_area;
	}

	public void setHousing_type(String housing_type) {
		this.housing_type = housing_type;
	}


	//String method
	@Override
	public String toString() {
		return super.toString() + String.format("%-8.2f %-10s", housing_area, housing_type);
	}

	
	/**
	 * Phương thức khởi tạo Housing
	 * @param n
	 * @return
	 */
	public static List<Housing> generateHousing(int n) {
		Housing[] hs = new Housing[n];
		
		String[] product_id = {
				"101", "102", "108",
				"111", "105", "119",
				"121", "114", "103",
				"104", "106", "107",
				"109", "110", "112"
		};
		
		String[] product_name = {
				"Housing1", "Housing2", "Housing3",
				"Housing4", "Housing5", "Housing6",
				"Housing7", "Housing8", "Housing9",
				"Housing10", "Housing11","Housing12",
				"Housing13", "Housing14", "Housing15"
		};
		
		long[] product_price = {
				12000000000L, 18000000000L, 21500000000L,
				20800000000L, 16880000000L, 32000000000L,
				43000000000L, 15500000000L, 33220000000L,
				35500000000L, 25500000000L, 12200000000L,
				42100000000L, 33800000000L, 21500000000L
		};
		
		int[] product_total = {
				1, 3, 5,
				2, 7, 4,
				3, 8, 6,
				4, 6, 7,
				1, 2, 8
		};
		
		double[] housing_area = {
				150, 188, 200,
				193, 166, 250,
				338, 160, 278,
				290, 199, 120,
				401, 388, 292
		};
		
		String[] housing_type = {
				"Home", "Apartment", "Villa",
				"Resort", "Shophouse", "Officetel", "Motel"
		};
		
		for(int i=0; i<n; i++) {
			hs[i] = new Housing();
			hs[i].setProduct_id(product_id[i]);
			hs[i].setProduct_name(product_name[i]);
			hs[i].setProduct_price(product_price[i]);
			hs[i].setProduct_total(product_total[i]);
			hs[i].setHousing_area(housing_area[i]);
			hs[i].setHousing_type(housing_type[(int)(Math.random()*housing_type.length)]);
		}
		Collections.addAll(list, hs);
		return list;
	}

	
	/**
	 * Phuong thuc sap xep theo price
	 * @param list
	 * @param isINC
	 * @return
	 */
	public static List<Housing> sortedHousingPrice(List<Housing> list, boolean isINC) {
		if(isINC) Collections.sort(list);
		else Collections.sort(list, Collections.reverseOrder());
//		fileWrite(list);
		return list;
	}
	

	/**
	 * Phuong thuc sap xep theo area
	 * @param list
	 * @return
	 */
	public static List<Housing> sortedHousingArea(List<Housing> list, boolean isINC) {
		if(isINC) Collections.sort(list, new sortedByArea());
		else Collections.sort(list, new sortedByArea().reversed());
		return list;
	}


	

	
	
	public static void printHousing(Housing[] list) {
		for(Housing p:list) {
			System.out.println(p);
		}
	}
	//Ham xuat
	public static void printHousing(List<Housing> list) {
		list.forEach(p -> System.out.println(p));
	}

}

class sortedByArea implements Comparator<Housing>{

	@Override
	public int compare(Housing o1, Housing o2) {
		double a1 = o1.getHousing_area();
		double a2 = o2.getHousing_area();
		
		int a = 0;
		if(a1 == a2) {
			a= 0;
		}
		if(a1>a2) {
			a= 1;
		}
		if(a1<a2) {
			a= -1;
		}
		return a;
	}
}	
