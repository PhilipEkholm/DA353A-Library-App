package library;

import java.awt.Dimension;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.add(new LoginView());
		frame.setPreferredSize(new Dimension(500, 200));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
