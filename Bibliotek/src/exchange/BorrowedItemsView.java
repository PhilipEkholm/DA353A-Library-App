package exchange;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BorrowedItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel 	personnrLabel = new JLabel("Ändra låntagare: "),
					returnLabel = new JLabel("Återlämna: ");
	private JTextArea currentItems = new JTextArea();
	private JTextField 	personField = new JTextField(),
						returnField = new JTextField();
	private JButton changePersonButton = new JButton("Ändra!"),
					returnItemButton = new JButton("Återlämna!");
	
	public BorrowedItemsView(){
		this.setLayout(new FlowLayout());
		currentItems.setEditable(false);
		
		this.setDimensions();
		this.setActionListeners();
		this.addComponents();
	}
	
	private void setDimensions(){
		personnrLabel.setPreferredSize(new Dimension(100, 25));
		returnLabel.setPreferredSize(new Dimension(100, 25));
		
		currentItems.setPreferredSize(new Dimension(300, 300));
		
		personField.setPreferredSize(new Dimension(100, 25));
		returnField.setPreferredSize(new Dimension(100, 25));
		
	}
	
	private void setActionListeners(){
		changePersonButton.addActionListener(new AL());
		returnItemButton.addActionListener(new AL());
	}
	
	private void addComponents(){
		this.add(personnrLabel);
		this.add(personField);
		this.add(changePersonButton);
		
		this.add(currentItems);
		
		this.add(returnLabel);
		this.add(returnField);
		this.add(returnItemButton);
	}
	
	private void changeLogin(){
		System.out.println("change login");
	}
	
	private void returnItem(){
		System.out.println("return item");
	}
	
	private class AL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			BorrowedItemsView ref = BorrowedItemsView.this;
			
			if(e.getSource() == changePersonButton){
				ref.changeLogin();
			}
			else if(e.getSource() == returnItemButton){
				ref.returnItem();
			}
		}
		
	}
}










