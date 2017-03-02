package library;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginController {
	private LoginView viewer;

	public void controller() {
		if (viewer.getPersonnr().length() != 10) {
			JOptionPane.showMessageDialog(null, "Var god ange ett giltigt personnummer");
		} else {
			JOptionPane.showMessageDialog(null, "nice");
		}
	}
}
