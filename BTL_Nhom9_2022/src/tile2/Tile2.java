package tile2;

import java.io.Serializable;
import java.util.Scanner;


public class Tile2 extends Product implements Serializable {
	
	public static final String TILE_TYPE = "No Tile_type";
	public static final double TILE_SIZE = 0.0;
	
	private String Tile_type;
	private double Tile_size;
	
	public Tile2() {
		this(Tile2.PRODUCT_ID, Tile2.PRODUCT_NAME, Tile2.PRODUCT_PRICE, Tile2.PRODUCT_TOTAL, Tile2.TILE_TYPE, Tile2.TILE_SIZE);
	}
	
	public Tile2(long product_id, String product_name, double product_price, int product_total, String Tile_type, double Tile_size) {
		super(product_id, product_name, product_price, product_total);
		this.Tile_type = Tile_type;
		this.Tile_size = Tile_size;
	}

	public String getTile_type() {
		return Tile_type;
	}

	public void setTile_type(String tile_type) {
		Tile_type = tile_type;
	}

	public double getTile_size() {
		return Tile_size;
	}

	public void setTile_size(double Tile_size) {
		this.Tile_size = Tile_size;
	}

	public String toString() {
		return super.toString()+" " + Tile_type + " "+ Tile_size+ "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof Tile2) {
            Tile2 another = (Tile2) obj;
            if (this.Tile_type.equals(another.Tile_type) &&
                this.Tile_size == another.Tile_size) {
                    return true;
            }
        }
        return false;
    }
}

