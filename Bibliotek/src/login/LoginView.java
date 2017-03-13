package login;

import java.awt.Color;
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


//public class LoginView extends JFrame {
//	private static final long serialVersionUID = 1L;
//	private JFrame frame = new JFrame("Login");
//	private JLabel loginLabel = new JLabel("Login View");
//	private JTextField 	field1 = new JTextField();
//	private JTextArea area1 = new JTextArea();
//	private JButton button1 = new JButton("Logga in");
//	private GridLayout gl = new GridLayout(3,0);
//	
//	public LoginView(){
//		loginLabel.setLayout(gl);
//		frame.setSize(400, 200);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		area1.setEditable(false);
//		area1.setText("Ange personnummer");
//	
//		loginLabel.add(area1);
//		loginLabel.add(field1);
//		loginLabel.add(button1);
//		
//		frame.add(loginLabel);
//		frame.setVisible(true);
//		button1.addActionListener(new ActionListener()
//		{
//		  public void actionPerformed(ActionEvent e)
//		  {
//		    if (checkUserNum(field1.getText()))
//		    	area1.setText("Välkommen!");
//		    else if (!checkUserNum(field1.getText())) {
//		    	area1.setText("Användare finns ej, var god ange personnumer");
//		    	loginLabel.add(area1, 0);
//		    }
//		}
//		});
//	}
//	
//	public boolean checkUserNum(String userNum) {
//		System.out.println(userNum);
//		if (Integer.parseInt(userNum) == 123)
//			return true;
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		LoginView lv = new LoginView();
//		
//	}

public class LoginView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel 	label1 = new JLabel("Mata in personnr (10 siffor) för att gå vidare: yymmdd-xxxx"),
					label2 = new JLabel("Personnr: ");
	private JTextField personField = new JTextField();
	private JButton sendBtn = new JButton("Gå vidare");
	

	public LoginView(LoginController controller){
		this.setPreferredSize(new Dimension(400, 120));
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		sendBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.validate(personField.getText());
			}
		});
		
		this.setDimensions();
		this.addComponents();
	}
	
	private void setDimensions(){
		label1.setBounds(10, 10, 400, 25);
		label2.setBounds(10, 50, 100, 25);
		personField.setBounds(80, 48, 160, 30);
		sendBtn.setBounds(250, 48, 90, 30);
	}
	
	private void addComponents(){
		this.add(label1);
		this.add(label2);
		this.add(personField);
		this.add(sendBtn);
	}

}
