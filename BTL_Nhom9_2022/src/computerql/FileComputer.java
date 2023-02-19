package computerql;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileComputer {
	public static void binaryOutputFile(List<Computer> list) throws IOException {
		
		FileOutputStream outFile = new FileOutputStream("Computer.bin");
		
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		
		out.writeInt(list.size());
		for(Computer com : list) {
			out.writeObject(com);
		}
		out.close();
	}
	
	public static List<Computer> binaryInputFile() throws IOException, ClassNotFoundException {
		FileInputStream inFile = new FileInputStream("Computer.bin");
		ObjectInputStream in = new ObjectInputStream(inFile);
		
		int n = in.readInt();
		List<Computer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((Computer) in.readObject());
		}
		in.close();
		return list;
	}
}
