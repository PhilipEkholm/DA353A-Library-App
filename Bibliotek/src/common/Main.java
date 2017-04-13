package common;
import controllers.LoginController;

/**
* 	Start the program from here.
*/

public class Main {
	public static void main(String[] args) {
		new LoginController("files/Lantagare.txt", "files/Media.txt");
	}
}