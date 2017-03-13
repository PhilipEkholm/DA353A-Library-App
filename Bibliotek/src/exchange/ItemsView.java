package exchange;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemsView extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel 	header = new JPanel();
	private JTextField searchField = new JTextField("Sökfält");
	private String[] comboString = { "Sök efter", "Media" , "Id" , "Författare" , "Titel" , "Utgivningsår" };
	private JComboBox<String> searchOption =  new JComboBox<String>(comboString);
	private GridLayout searchGrid = new GridLayout(2,0);
	private JButton searchButton = new JButton("Sök");
	
	
	public ItemsView(){
		this.setLayout(new BorderLayout());
		
		this.setDimensions();
		this.setActionListeners();
		this.addComponents();
	}
	
	private void setDimensions(){
		searchField.setPreferredSize(new Dimension(200,25));
		searchOption.setPreferredSize(new Dimension(150,25));
		searchButton.setPreferredSize(new Dimension(100,25));
		
		
	}
	
	private void setActionListeners(){
		searchButton.addActionListener(new AL());
	}
	
	private void addComponents(){
		header.add(searchField);
		header.add(searchOption);
		header.add(searchButton);
		this.add(header, BorderLayout.NORTH);
	}
	
	private class AL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//search(searchField.getText(), searchOption.getSelectedItem()); 
		}
		
	}
}


























