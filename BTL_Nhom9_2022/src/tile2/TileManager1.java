package tile2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class TileManager1{
	static Scanner sc = new Scanner(System.in);
	public static List<Tile2> lst = new ArrayList<>(); 
	private String LuaChon;
	
	public String getLuaChon() {
		return LuaChon;
	}

	public void setLuaChon(String luaChon) {
		LuaChon = luaChon;
	}
	
	public boolean ADD(Tile2 tl, List<Tile2> list) {
		list.add(tl);
		return true;
	}
	
	public boolean addTile(Tile2 tl) {
		ADD(tl, Tile2GUI.list);
		try {
			MyFile.binaryOutputFile(Tile2GUI.list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	public boolean editTile(Tile2 t) {
	    int index = indexOfTile(t.getProduct_id());
	    t = new Tile2(t.getProduct_id(), t.getProduct_name(), t.getProduct_price(), t.getProduct_total(), t.getTile_type(), t.getTile_size());
	    if (index < 0) {
	      return false;
	    }
	    lst.set(index, t);
	    return true;

	}
	
	
	
	public int indexOfTile(long id) {
		int index = -1;
		for(int i = 0; i < lst.size(); i++) {
			if(lst.get(i).getProduct_id() == id)
				index = i;
		}
		return index;
	}
	

	public List<Tile2> searchTile(String name) {
		List<Tile2> output = new ArrayList<>();
		name = name.toLowerCase();
	    for (Tile2 tile : Tile2GUI.list) {
	      if (tile.getProduct_name().toLowerCase().contains(name)) {
	        output.add(tile);
	      }
	    }
	    return output;
	}

	public List<Tile2> searchTile(double price) {
		List<Tile2> output = new ArrayList<>();
	    for (Tile2 tile : Tile2GUI.list) {
	      if (tile.getProduct_price() >= price) {
	        output.add(tile);
	      }
	    }
	    return output;
	}	

	public List<Tile2> searchTile1(String type) {
		List<Tile2> output = new ArrayList<>();
	    for (Tile2 tile : lst) {
	      if (tile.getTile_type().equals(type)) {
	        output.add(tile);
	      }
	    }
	    return output;
	}	

	public void inDanhSachTile() {
		for (Tile2 tile : lst) {
			System.out.println(tile);
		}
	}
	public List<Tile2> sortedTile(double price) {
		List<Tile2> lst1 = new ArrayList<>();
		for(Tile2 tile : lst) {
			if(tile.getProduct_price() >= price) {
				lst1.add(tile);
			}
		}
		System.out.println("Chon chieu sap xep|| 1: tăng dân, 2: giảm dần ");
		
		int isINC = sc.nextInt();
		if(isINC == 1) {
			Collections.sort(lst1, new SortedByPrice());
		}else {
			Collections.sort(lst1, new SortedByPrice().reversed());
		}
		return lst1;
	}

	public List<Tile2> sortedTile(String type) {
		List<Tile2> lst1 = new ArrayList<>();
		for(Tile2 t : lst) {
			if(t.getTile_type().compareToIgnoreCase(type) >= 0) {
				lst1.add(t);
			}
		}
		if(lst1.isEmpty()) {
			return null;
		} else {
			System.out.println("Chon chieu sap xep|| 1: tăng dân, 2: giảm dần");
			int isINC = sc.nextInt();
			if(isINC == 1) {
				Collections.sort(lst1, new sortedByType());
			}else {
				Collections.sort(lst1, new sortedByType().reversed());
			}
			return lst1;
		}
	}
	public static void ghiFile() {
		for(Tile2 tile : lst) {
			System.out.println(tile.toString());
		}
		try {
			MyFile.binaryOutputFile(lst);
			MyFile.binaryInputFile("Tile2.bin", lst.size());
		} catch (IOException | ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean deleTile(Tile2 tl) {
		for (Tile2 tile : Tile2GUI.list) {
			if (tile.equals(tl)) {
				Tile2GUI.list.remove(tl);
				return true;
			}
		}
		return false;
	}
		public static List<Tile2> generatedTile(int n) {
			String[] type = {"Gach men", "Gach bong kieng", "Gach bong", "Gach Granite"," Gach Ceramic"," Gach gia go"};
			Tile2[] list = new Tile2[n];
			List<Tile2> tile = Arrays.asList(list);
			for(int i = 0; i < n; i++) {
				list[i] = new Tile2();
				int indexType = (int) (Math.random() * type.length);
				list[i].setProduct_id(i + 1);
				list[i].setProduct_name("Tile" + (int)(Math.random() * 50));
				list[i].setProduct_price((int)(100000 + (int)(Math.random()*500000)));
				list[i].setProduct_total(1 + (int)(Math.random()*20));
				list[i].setTile_type(type[indexType]);
				list[i].setTile_size(400 + (int)(Math.random()*1000));	
			}
			return tile;
		}

}
class Item {
	
	private String key;
	private String value;

	public Item(String key, String value){
	    this.key = key;
	    this.value = value;
	}
		@Override
	public String toString(){
	    return key;
	}

	public String getKey(){
	    return key;
	}

	public String getValue(){
	    return value;
	}
}
class SortedByPrice implements Comparator<Tile2> {
    // Ham so sanh 2 doi tuong 
    public int compare(Tile2 a, Tile2 b) {
        return (int) (a.getProduct_price() - b.getProduct_price());
    }

}

class sortedByType implements Comparator<Tile2>{

	@Override
	public int compare(Tile2 o1, Tile2 o2) {
		// TODO Auto-generated method stub
		String type1 = o1.getTile_type();
		String type2 = o2.getTile_type();
		
		//Vi tri cat chi ten
		byte at = (byte)type1.lastIndexOf(" ");
		if(at!=-1) {
			type1 = type1.substring(at+1);
		}
		at = (byte)type2.lastIndexOf(" ");
		if(at!=-1) {
			type2 = type2.substring(at+1);
		}
		return type1.compareToIgnoreCase(type2);
	}
	
}
