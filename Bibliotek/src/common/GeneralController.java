package common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import login.LoginController;
import structures.HashtableOH;;

public class GeneralController {
	protected Person persons[];
	private HashtableOH<String,Person> people = new HashtableOH<String,Person>(20);
	
	public void loadPersons(){
		
		int index = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("files/Lantagare.txt"), "UTF-8"));
			String text = br.readLine();
			String[] parts;
			while (text != null) {
				parts = text.split(";");
				System.out.println(parts[2]);
				people.put(parts[0], new Person(parts[0], parts[1], parts[2]));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public boolean userExists(String userKey) {
		return people.containsKey(userKey);
	}
}
