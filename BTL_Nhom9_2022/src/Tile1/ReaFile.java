package Tile1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReaFile {
public static void binaryOutputFile(List<Tile> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("Tile.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Tile tl : list) {
			out.writeObject(tl);
		}
		out.close();
	}
	
	public static List<Tile> binaryInputFile() throws IOException, ClassNotFoundException {
		FileInputStream inFile = new FileInputStream("Tile.bin");
		ObjectInputStream in = new ObjectInputStream(inFile);
		
		int n = in.readInt();
		List<Tile> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Tile) in.readObject());
		}
		in.close();
		return list;
	}
	
	
}
