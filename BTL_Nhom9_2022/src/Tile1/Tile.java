package Tile1;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Tile extends Product implements Serializable {
	public static final float TILE_SIZE = 0;
	public static final String TILE_COLOR ="KHÔNG" ;

	private float tile_size;
	private String tile_color;
	
	public Tile() {
		this(Tile.PRODUCT_ID, Tile.PRODUCT_NAME,Tile.PRODUCT_PRICE,Tile.PRODUCT_TOTAL,Tile.TILE_SIZE, Tile.TILE_COLOR);
	}
	
	public Tile(int product_id, String product_name, double product_price, int product_total, float tileSize,
			String tile_color) {
		super(product_id, product_name, product_price, product_total);
		this.tile_size = tileSize;
		this.tile_color = tile_color;
	}

	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Tile[ tile_size=" + tile_size   + ", tile_color="+ tile_color + "]\n";
	}
	public  String getLine() {
		return  "\n" + "Tile[ tile_size=" + tile_size   + ", tile_color="+ tile_color + "]\n";
	}
	public float gettile_size() {
		return tile_size;
	}
	public String gettile_color() {
		return tile_color;
	}
	public void settile_size(float tile_size) {
		this.tile_size = tile_size;
	}
	public void setTile_color(String tile_color) {
		this.tile_color = tile_color;
	}

	@Override
	//so sánh hai đối tượng có giống nhau không
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Tile)) {
			return false;
		}
		Tile otherTile = (Tile) obj;
		if (this.getProduct_name() == otherTile.getProduct_name()) {
			return true;
		}		
		return false;
	}
	public static List<Tile>generateTile(int n) {
		Tile[] list = new Tile[n];
		List<Tile> lt =  Arrays.asList(list);
		// danh tên sản phẩm
		String[] product_name = { "Gạch men", "Gạch Granite", "Gạch Ceramic", "Gạch Ceramic", "Gạch bông", };
		// danh màu

		String[] color = { "Xanh", "Do", "Tim", "Vang", "Cam", "Xanh Luc ", "Nau", };
		// thực hiện sinh ngẫu nhiên danh sách
		int index;
		for (int i = 0; i < n; i++) {
			// khởi tạo bộ nhớ cho mảng
			list[i] = new Tile();

			// sinh tên sản phẩm
			index = (int) (Math.random() * product_name.length);
			list[i].setProduct_name(product_name[index]);

			// sinh màu
			index = (int) (Math.random() * color.length);
			list[i].setTile_color(color[index]);

			index = 0 + (int) (Math.random() * 100);
			list[i].setProduct_id((byte) index);

			index = 0 + (int) (Math.random() * 100);
			list[i].setProduct_price( index);

			index = 0 + (int) (Math.random() * 100);
			list[i].setProduct_total( index);

			index = 0 + (int) (Math.random() * 100);
			list[i].settile_size(index);

		}
		return lt;
	}

}
