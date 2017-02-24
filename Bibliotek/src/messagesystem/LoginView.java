package messagesystem;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class LoginView extends JPanel{
	private JLabel loginLabel = new JLabel("Login View");
	private JTextField 	field1 = new JTextField(),
						field2 = new JTextField();
	private JButton button1 = new JButton("Logga in");
	
	public LoginView(){
		setLayout(new FlowLayout());
		add(loginLabel);
		field1.setPreferredSize(new Dimension(100, 25));
		field2.setPreferredSize(new Dimension(100, 25));
		add(field2);
		add(field1);
		button1.setPreferredSize(new Dimension(50, 15));
		add(button1);
	}
}
