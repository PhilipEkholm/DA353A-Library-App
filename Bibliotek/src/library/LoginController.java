package library;

import javax.swing.JFrame;

public class LoginController {
	public static void main(String[] args) {
		LoginController lc = new LoginController();
		lc.startupJFrame();
	}
	
	private void startupJFrame(){
		JFrame frame = new JFrame();
		frame.add(new LoginView());
	}
}
