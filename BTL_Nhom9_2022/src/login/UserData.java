package login;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;




public class UserData {	
	public static ArrayList<User> us = new ArrayList<>();
	public static ArrayList<User> generateUser() {
		User[] lst = new User[5];
		String[] username = {
				"hung", "cuong", "duy", "dung", "admin"
		};

		for(int i=0; i<5; i++) {
			lst[i] = new User();
			lst[i].setUsername(username[i]);
			lst[i].setPassword("123");
		}
		Collections.addAll(us, lst);
		return us;
	}
	
	
	public static void fileWrite(ArrayList<User> lst) {
		try {
			FileOutputStream in = new FileOutputStream("account.bin");
			ObjectOutputStream ow = new ObjectOutputStream(in);
			
			
			ow.writeInt(lst.size());
				for(User o:lst) {					
					ow.writeObject(o);;
				}
			in.close();
			ow.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<User> fileRead() throws IOException, ClassNotFoundException {
			FileInputStream inFile = new FileInputStream("account.bin");
			ObjectInputStream in = new ObjectInputStream(inFile);
			
			ArrayList<User> list = new ArrayList<>();
			in.readInt();
			
			for(int i=0; i<5; i++) {
				list.add((User) in.readObject());
			}
			inFile.close();
			in.close();
			return list;
	}
}
