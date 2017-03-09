package login;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

<<<<<<< HEAD
public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame = new JFrame("Login");
	private JLabel loginLabel = new JLabel("Login View");
	private JTextField 	field1 = new JTextField();
	private JTextArea area1 = new JTextArea();
	private JButton button1 = new JButton("Logga in");
	private GridLayout gl = new GridLayout(3,0);
	
	public LoginView(){
		loginLabel.setLayout(gl);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		area1.setEditable(false);
		area1.setText("Ange personnummer");
	
		loginLabel.add(area1);
		loginLabel.add(field1);
		loginLabel.add(button1);
		
		frame.add(loginLabel);
		frame.setVisible(true);
		button1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    if (checkUserNum(field1.getText()))
		    	area1.setText("Välkommen!");
		    else if (!checkUserNum(field1.getText())) {
		    	area1.setText("Användare finns ej, var god ange personnumer");
		    	loginLabel.add(area1, 0);
		    }
		}
		});
	}
	
	public boolean checkUserNum(String userNum) {
		System.out.println(userNum);
		if (Integer.parseInt(userNum) == 123)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		LoginView lv = new LoginView();
		
	}
=======
public class LoginView extends JPanel{
	
>>>>>>> master
}
