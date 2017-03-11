package login;

import javax.swing.JOptionPane;

import common.GeneralController;

/**
 *	LoginController
 *
 * 	The LoginController is responsible for starting up the LoginView,
 * 	as well as validating the number used for logging in.
 */

public class LoginController extends GeneralController{
	
	/**
	 *	Default constructor will take arguments for loading
	 *	in files required for the structure to work. These will 
	 *	be sent to the super class for processing.
	 *
	 * 	@param filePathPersons the String containing the file
	 * 	path for loading lantagare.txt
	 */
	
	public LoginController(String filePathPersons){
		super(filePathPersons);
	}
	
	/**
	 *	The method will call  
	 */
	
	public void startLoginView(){
		super.loadWindow(new LoginView(this), "Logga in");
	}
	
	/**
	 *	Validates the number passed in, will allow access
	 *	if number can be found as key. Result will be shown as
	 *	a JOptionPane.
	 *
	 * 	@param number number entered in the loginView
	 */
	
	public void validate(String number){
		String res = "";
		
		if(persons.containsKey(number)){
			res += "Inloggning gick, du kommer nu omdirigeras.";
		}
		else{
			res += "Inloggning gick ej, försök igen.";
		}
		
		JOptionPane.showMessageDialog(null, res);
	}
}










