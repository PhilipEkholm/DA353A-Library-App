package library;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class LoginView extends JPanel {
	private JLabel rubrik = new JLabel("Bibliotek");
	private JLabel info = new JLabel("Personnr (10 tecken)");
	private JButton button = new JButton("Fortsätt");
	private JTextField field = new JTextField();
	private LoginController login = new LoginController();

	public LoginView() {
		setLayout(new BorderLayout());
		add(rubrik, BorderLayout.NORTH);
		add(info, BorderLayout.WEST);
		add(field, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);

		ButtonListener listner = new ButtonListener();
		button.addActionListener(listner);
	}

	public String getPersonnr() {
		return field.getText();
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			login.controller();
		}
	}
}
