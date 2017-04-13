package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.LoginController;

/**
* The login view for entering the personnr.
*/
public class LoginView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel 	label1 = new JLabel("Mata in personnr (10 siffor) för att gå vidare: yymmdd-xxxx"),
					label2 = new JLabel("Personnr: ");
	private JTextField personField = new JTextField();
	private JButton sendBtn = new JButton("Gå vidare");

	/**
	* Pass reference to the controller since communication
	* back will be necessary.
	*
	* @param controller the controller that instantiated
	* this view.
	*/
	
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

	/**
	* Set the dimensions of objects.
	*/

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











