package exchange;

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

public class BorrowedItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ItemsController controller;
	private JLabel 	personnrLabel = new JLabel("Välkommen!"),
					returnLabel = new JLabel("Återlämna: ");
	private JTextArea currentItems = new JTextArea();
	private JTextField returnField = new JTextField();
	private JButton returnItemButton = new JButton("Återlämna!");
	private JScrollPane scrollPane = new JScrollPane(currentItems);
	
	public BorrowedItemsView(ItemsController controller){
		this.setLayout(new FlowLayout());
		currentItems.setEditable(false);
		this.controller = controller;
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		this.setDimensions();
		this.setActionListeners();	
		this.addComponents();
	}
	
	private void setDimensions(){
		personnrLabel.setPreferredSize(new Dimension(100, 25));
		returnLabel.setPreferredSize(new Dimension(100, 25));
		scrollPane.setPreferredSize(new Dimension(500, 300));
		currentItems.setPreferredSize(new Dimension(500, 300));
		returnField.setPreferredSize(new Dimension(100, 25));
	}
	
	private void setActionListeners(){
		returnItemButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				BorrowedItemsView ref = BorrowedItemsView.this;
				controller.returnItem(ref.returnField.getText());
			}
		});
	}
	
	private void addComponents(){
		this.add(personnrLabel);
		this.add(scrollPane);
		
		this.add(returnLabel);
		this.add(returnField);
		this.add(returnItemButton);
	}
	
	public void setBorrowedItems(String items){
		this.currentItems.setText(items);
	}
}











