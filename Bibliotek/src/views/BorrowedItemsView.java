package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import controllers.ItemsController;

/**
*	BorrowedItemsView
*
* 	The view for currently borrowed media objects.
* 	From here borrowed objects can be listed and returned. 
*/

public class BorrowedItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ItemsController controller;
	private JLabel 	personnrLabel = new JLabel("Välkommen!"),
					returnLabel = new JLabel("Återlämna: ");
	private JTextArea currentItems = new JTextArea();
	private JTextField returnField = new JTextField();
	private JButton returnItemButton = new JButton("Återlämna!"),
					changeUserButton = new JButton("Byt användare");
	private JScrollPane scrollPane = new JScrollPane(currentItems);

	/**
	* 	controller will be passed since communication is necessary.
	*
	* 	@param controller the controller controlling the
	*   current view (ItemsController)
	*/
	
	public BorrowedItemsView(ItemsController controller){ 
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(500, 400));
		currentItems.setEditable(false);
		this.controller = controller; 
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.setDimensions();
		this.setActionListeners();
		this.addComponents();
	}

	private void setDimensions(){ 
		personnrLabel.setPreferredSize(new Dimension(200, 25)); 
		returnLabel.setPreferredSize(new Dimension(100, 25)); 
		changeUserButton.setPreferredSize(new Dimension(130, 25));
		scrollPane.setPreferredSize(new Dimension(500, 300)); 
		currentItems.setPreferredSize(new Dimension(500, 300)); 
		returnField.setPreferredSize(new Dimension(100, 25));
	}
	
	
	private void setActionListeners(){ 
		AL buttonListener = new AL();
		
		returnItemButton.addActionListener(buttonListener);
		changeUserButton.addActionListener(buttonListener);
	}
	
	private class AL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			BorrowedItemsView outerClass = BorrowedItemsView.this;
			
			if(e.getSource() == returnItemButton){
				controller.returnItem(outerClass.returnField.getText());
			}
			else if(e.getSource() == changeUserButton){
				//controller.changeUser(loginField.getText());
				controller.logOut();
			}
		}
	}
	
	public void setWelcomeText(String text){
		personnrLabel.setText(text);
	}

	private void addComponents(){
        this.add(personnrLabel);
        this.add(changeUserButton);
        this.add(scrollPane);
    	this.add(returnLabel);
    	this.add(returnField);
    	this.add(returnItemButton);
	}
	
	public void setBorrowedItems(String items){ 
		this.currentItems.setText(items);
	} 
}





