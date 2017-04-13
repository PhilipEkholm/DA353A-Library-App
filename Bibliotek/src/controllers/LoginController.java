package controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.LibraryModel;
import models.Person;
import models.PersonModel;
import views.LoginView;

/**
* LoginController
*
* The LoginController is responsible for starting up the LoginView,
* as well as validating the number used for logging in.
*/

public class LoginController{
	private LoginView view = new LoginView(this);
	private PersonModel personModel;
	private LibraryModel libraryModel;
	private Person loggedInPerson;
	private JFrame frame;

	/**
	* Default constructor will take arguments for loading
	* in files required for the structure to work. These will
	* be sent to the super class for processing.
	*
	* @param filePathPersons the String containing the file
	* path for loading lantagare.txt
	*/

	public LoginController(String filePathPersons, String filePathMedia){
		personModel = new PersonModel(filePathPersons);
		libraryModel = new LibraryModel(filePathMedia);
		
		this.setupJFrame();
	}
	
	public LoginController(PersonModel pm, LibraryModel lm){
		personModel = pm;
		this.libraryModel = lm;
		
		this.setupJFrame();
	}
	
	private void setupJFrame(){
		this.frame= new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(view);
		frame.setLocation(50, 50);
		
		frame.pack();
		frame.setVisible(true);
	}

	/**
	* Validates the number passed in, will allow access
	* if number can be found as key. A confirmDialog
	* will then be opened to confirm the login.
	*
	* If accepted, a LibraryController will be instantiated.
	*
	* @param number number entered in the loginView
	*/

	public void validate(String number){
		if(personModel.contains(number)){
			int result = JOptionPane.showConfirmDialog(null, "Inloggning gick, vill du gå vidare?");
			if(result == JOptionPane.OK_OPTION){
				view.setVisible(false);
				loggedInPerson = personModel.get(number);
				new ItemsController(personModel, libraryModel, loggedInPerson);
				frame.setVisible(false);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Inloggning gick ej, försök igen.");
		}
	}
}







