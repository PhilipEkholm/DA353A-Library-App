package exchange;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ItemsController controller;
	private JPanel 	headerPanel = new JPanel();
	private JPanel libraryPanel = new JPanel();
	private JPanel borrowPanel = new JPanel();
	private JLabel searchLabel = new JLabel("Sök efter media:");
	private JLabel borrowLabel = new JLabel("Ange media id:");
	private JTextField searchField = new JTextField();
	private JTextField borrowField = new JTextField();
	private String[] comboString = { "Sök efter", "Media" , "Id" , "Författare" , 
									"Titel" , "Utgivningsår", "Skådespelare" };
	private JComboBox<String> searchOption =  new JComboBox<String>(comboString);
	private JButton searchButton = new JButton("Sök");
	private JButton borrowButton = new JButton("Låna");
	private JTextArea 	books = new JTextArea("Böcker"),
						dvds = new JTextArea("DVD:er");
	
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
		searchLabel.setPreferredSize(new Dimension(120,25));
		searchField.setPreferredSize(new Dimension(200,25));
		searchOption.setPreferredSize(new Dimension(150,25));
		searchButton.setPreferredSize(new Dimension(100,25));
		borrowLabel.setPreferredSize(new Dimension(120,25));
		borrowField.setPreferredSize(new Dimension(150,25));
		borrowButton.setPreferredSize(new Dimension(100,25));
		books.setPreferredSize(new Dimension(300,500));
		dvds.setPreferredSize(new Dimension(300, 500));
		
	}
	
	private void setActionListeners(){
		searchButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		borrowButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemsView ref = ItemsView.this;
				
				controller.borrow(ref.borrowField.getText());
			}
		});
	}
	
	private void addComponents(){
		headerPanel.add(searchLabel);
		headerPanel.add(searchField);
		headerPanel.add(searchOption);
		headerPanel.add(searchButton);
		
		libraryPanel.add(books);
		libraryPanel.add(dvds);
		
		borrowPanel.add(borrowLabel);
		borrowPanel.add(borrowField);
		borrowPanel.add(borrowButton);
		
		this.add(headerPanel, BorderLayout.NORTH);
		this.add(libraryPanel, BorderLayout.CENTER);
		this.add(borrowPanel, BorderLayout.SOUTH);
	}
	
	public void setItems(String books, String DVDs){
		this.books.setText(books);
		this.dvds.setText(DVDs);
	}
}


























