package views;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.ItemsController;

/**
* ItemsView
*
* Items from the collection will be listed here, from here
* you can also borrow a certain item by filling in the id of it.
*/

public class ItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ItemsController controller;
	private JPanel libraryPanel = new JPanel();
	private JPanel borrowPanel = new JPanel();
	private JLabel borrowLabel = new JLabel("Ange media id:");
	private JTextField borrowField = new JTextField();
	private JButton borrowButton = new JButton("Låna");
	private JTextArea books = new JTextArea("Böcker"),
			dvds = new JTextArea("DVD:er");

	/**
	* Controller is passed with since communication is
	* necessary.
	*
	* @param controller a reference to the controller
	* that instantiated this view.
	*/

	public ItemsView(ItemsController controller){
		this.setLayout(new BorderLayout());
		this.controller = controller;
		this.setDimensions();
		this.setActionListeners();
		this.addComponents();
		libraryPanel.setLayout(new GridLayout(1, 2, 20, 20));
		books.setEditable(false);
		dvds.setEditable(false);
	}

	private void setDimensions(){
		borrowLabel.setPreferredSize(new Dimension(120,25));
		borrowField.setPreferredSize(new Dimension(150,25));
		borrowButton.setPreferredSize(new Dimension(100,25));
		books.setPreferredSize(new Dimension(500,500));
		dvds.setPreferredSize(new Dimension(500, 500));
	}

	private void setActionListeners(){
		borrowButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemsView ref = ItemsView.this;
				controller.borrow(ref.borrowField.getText());
			}
		});
	}

	private void addComponents(){
		libraryPanel.add(books);
		libraryPanel.add(dvds);
		borrowPanel.add(borrowLabel);
		borrowPanel.add(borrowField);
		borrowPanel.add(borrowButton);
		
		this.add(libraryPanel, BorderLayout.CENTER);
		this.add(borrowPanel, BorderLayout.SOUTH);
	}

	/**
	* Refresh the view with current items.
	*
	* @param books the books as strings with toString
	* @param DVDs the DVDs passed as strings with toString
	*/
	
	public void setItems(String books, String DVDs){
		this.books.setText(books);
		this.dvds.setText(DVDs);
	}
}






