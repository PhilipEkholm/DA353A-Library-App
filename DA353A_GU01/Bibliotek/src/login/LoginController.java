package login;

import javax.swing.JOptionPane;

import common.GeneralController;
import exchange.ItemsController;

/**
 *	LoginController
 *
 * 	The LoginController is responsible for starting up the LoginView,
 * 	as well as validating the number used for logging in.
 */

public class LoginController extends GeneralController{
	private String filePathPersons;
	private LoginView view = new LoginView(this);
	
	/**
	 *	Default constructor will take arguments for loading
	 *	in files required for the structure to work. These will 
	 *	be sent to the super class for processing.
	 *
	 * 	@param filePathPersons the String containing the file
	 * 	path for loading lantagare.txt
	 */
	
	public LoginController(String filePathPersons){
		super(filePathPersons, null);
		this.filePathPersons = filePathPersons;
	}
	
	public void startLoginView(){
		super.loadWindow(view, "Logga in");
	}
	
	/**
	 *	Validates the number passed in, will allow access
	 *	if number can be found as key. A confirmDialog
	 *	will then be opened to confirm the login.
	 *
	 *	If accepted, a LibraryController will be instantiated.
	 *
	 * 	@param number number entered in the loginView
	 */
	
	public void validate(String number){
		if(persons.contains(number)){
			int result = JOptionPane.showConfirmDialog(null, "Inloggning gick, vill du gå vidare?");
			
			if(result == JOptionPane.OK_OPTION){
				view.setVisible(false);
				
				new ItemsController(filePathPersons, super.getWindow(0), persons.get(number));
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Inloggning gick ej, försök igen.");
		}
	}
}









