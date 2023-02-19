package menuquanly;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Statistic {

	public static void fileWrite(List<TypeStatic> li, String fileName) throws IOException {
		FileOutputStream in = new FileOutputStream(fileName);
		ObjectOutputStream ow = new ObjectOutputStream(in);
		
		ow.writeInt(li.size());
		for(TypeStatic o:li) {					
			ow.writeObject(o);
		}
		
		ow.close();			
	}
	
	public static ArrayList<TypeStatic> fileRead(String fileName) throws IOException, ClassNotFoundException {
			FileInputStream inFile = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(inFile);
			
			ArrayList<TypeStatic> temp = new ArrayList<>();
			
			int n = in.readInt();
			
			for(int i=0; i<n; i++) {									
				temp.add((TypeStatic) in.readObject());
			}
			
			
			in.close();
			return temp;
	}
}

