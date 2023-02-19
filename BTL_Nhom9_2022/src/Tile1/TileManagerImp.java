package Tile1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Tile1.*;



public class TileManagerImp {
	static Scanner sc = new Scanner(System.in);

//	private static List<Tile> lst = new ArrayList<>();

// thêm
	public boolean addTile(Tile t) {
		add(t, TileGUI.list);
		try {
			ReaFile.binaryOutputFile(TileGUI.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

// sửa
	public boolean add(Tile t, List<Tile> list) {
		list.add(t);
		return true;

	}


// tìm kiếm
	public List<Tile> searchTile(String name) {
		List<Tile> t = new ArrayList<>();
		for (Tile o : TileGUI.list) {
			if (o.getProduct_name().compareToIgnoreCase(name) == 0)
				t.add(o);
		}
		return t;
	}

	public List<Tile> searchTile(double price) {
		List<Tile> t = new ArrayList<>();
		for (Tile o : TileGUI.list) {
			if (o.getProduct_price() == price)
				t.add(o);
		}
		return t;
	}
	public List<Tile> searchTileBySize(double size) {
		List<Tile> t = new ArrayList<>();
		for (Tile o : TileGUI.list) {
			if (o.gettile_size() == size)
				t.add(o);
		}
		return t;
	}

	public List<Tile> searchTileByColor(String color) {
		List<Tile> t = new ArrayList<>();
		for (Tile o : TileGUI.list) {
			if (o.gettile_color().compareToIgnoreCase(color) == 0)
				t.add(o);
		}
		return t;
	}

// sắp xếp
	public List<Tile> sortedTile(double price) {
		if (price == 0)
			Collections.sort(TileGUI.list, new sortedByPrice());
		else
			Collections.sort(TileGUI.list, new sortedByPrice().reversed());
		return TileGUI.list;
	}

	public List<Tile> sortedTile(float size) {
		if (size == 0)
			Collections.sort(TileGUI.list, new sortedBysize());
		else
			Collections.sort(TileGUI.list, new sortedBysize().reversed());
		return TileGUI.list;
	}

	public List<Tile> sortedTile(byte count) {
		if (count == 0)
			Collections.sort(TileGUI.list, new sortedByColor());
		else
			Collections.sort(TileGUI.list, new sortedByColor().reversed());
		return TileGUI.list;
	}

	public boolean checkTile(Tile o, List<Tile> list) {
		for (Tile t : list) {
			if (o.getProduct_id() == t.getProduct_id()) {
				return true;
			}
		}
		return false;
	}

}


class sortedByPrice implements Comparator<Tile> {

	@Override
	public int compare(Tile o1, Tile o2) {
		return (int) (o1.getProduct_price() - o2.getProduct_price());
	}
}

class sortedBysize implements Comparator<Tile> {

	@Override
	public int compare(Tile o1, Tile o2) {
		return (int) (o1.gettile_size() - o2.gettile_size());
	}
}

class sortedByColor implements Comparator<Tile> {

	@Override
	public int compare(Tile o1, Tile o2) {
		return o1.gettile_color().compareToIgnoreCase(o2.gettile_color());
	}

}
