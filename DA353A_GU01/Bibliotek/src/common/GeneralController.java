package common;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

import arraylist.ArrayList;
import avltree.AVLTree;

/**
 *	GeneralController
 *
 * 	The GeneralController class is responsible for starting windows, loading
 * 	in files and storing them into suitable data-structures.
 */

public class GeneralController {
	protected AVLTree<String, Person> persons = new AVLTree<String, Person>();
	private ArrayList<JFrame> windowSessions = new ArrayList<JFrame>();
	protected Person currentlyLoggedIn;
	
	public GeneralController(String filePath, Person currentlyLoggedIn){
		this.loadPersons(filePath);
		this.currentlyLoggedIn = currentlyLoggedIn;
	}
	
	private void loadPersons(String filePath){
		try {
			GeneralController.readPersons(persons, filePath);
		} catch (FileNotFoundException e) {
			System.out.println("Filen " + filePath + "Kunde ej hittas");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Felaktig ström!");
			e.printStackTrace();
		}
	}
	
	protected void loadWindow(JPanel panel, String windowTitle){
		JFrame frame = new JFrame(windowTitle);
		windowSessions.add(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(40, 40);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	protected JFrame getWindow(int index){
		return windowSessions.get(index);
	}
	
	protected void addFrame(JFrame frame){
		windowSessions.add(frame);
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
}







