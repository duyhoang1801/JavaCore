package tile2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyFile {
public static void binaryOutputFile(List<Tile2> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("Tile2.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Tile2 tl : list) {
			out.writeObject(tl);
		}
		out.close();
	}
	
	public static List<Tile2> binaryInputFile(String name, int n) throws IOException, ClassNotFoundException {
		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileInputStream inFile = new FileInputStream(name);
		// Khai báo đối tượng thực hiện xuất
		ObjectInputStream in = new ObjectInputStream(inFile);

		in.readInt();
		List<Tile2> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Tile2) in.readObject());
		}
		in.close();
		return list;
	}
	public static int countObject() throws IOException {
		FileInputStream inFile = new FileInputStream("Tile2.bin");
		ObjectInputStream in = new ObjectInputStream(inFile);
		int count = in.readInt();
		in.close();
		return count;
	}
	
	public static Tile2 findComputerinFile(int id) {
		for (Tile2 tl : Tile2GUI.list) {
			if (tl.getProduct_id() == id) {
				return tl;
			}
		}
		return null;
	}
}
