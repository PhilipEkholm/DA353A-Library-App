package models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import collections.AVLTree;

/**
 *	PersonsModel
 *
 * 	A model for storing and accessing persons-objects.
 * 	@author Philip Ekholm
 * 	@date 2017-04-01 12:13
 */

public class PersonModel {
	private AVLTree<String, Person> persons = new AVLTree<String, Person>();
	
	public PersonModel(String filePath){
		try{
			PersonModel.readPersons(persons, filePath);
		}
		catch(FileNotFoundException e1){
			e1.printStackTrace();
		}
		catch(IOException e2){
			e2.printStackTrace();
		}
	}
	
	public static void readPersons(AVLTree<String, Person> tree, String filePath) 
		throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			while (line != null) {
				String[] details = line.split(";");
				Person p = new Person(details[0], details[1], details[2]);
				tree.put(p.getPersonnr(), p);
				line = br.readLine();
			}
		}
	}
	
	public boolean contains(String key){
		return persons.contains(key);
	}
	
	public Person get(String key){
		return persons.get(key);
	}
}









