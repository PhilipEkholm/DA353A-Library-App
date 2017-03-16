package library;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.GeneralController;

public class MediaGUI {
	private GeneralController controller;	
	private JFrame frame = new JFrame("Sök i Skåne");
	private JTabbedPane jtp = new JTabbedPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel gridPanel1 = new JPanel();
	private JPanel gridPanel2 = new JPanel();
	private JPanel gridPanel3 = new JPanel();
	private JLabel tab1 = new JLabel();
	private JLabel tab2 = new JLabel();
	private GridLayout bigGrid = new GridLayout(3,0);
	private GridLayout topGrid = new GridLayout(0,3);
	private GridLayout bottomGrid = new GridLayout(3,0);
	private JTextField searchField = new JTextField();
	private JRadioButton rbAll = new JRadioButton("Sök all media", true);
	private JRadioButton rbBook = new JRadioButton("Sök bland böcker");
	private JRadioButton rbDVD = new JRadioButton("Sök bland DVD");
	private ButtonGroup group = new ButtonGroup();
	public JButton searchButton = new JButton("Sök");
	private JTextArea textArea1 = new JTextArea(36,56);
	private JTextArea textArea2 = new JTextArea(36,56);
	
	public MediaGUI() { 
	//	this.controller = controller;
		frame.getContentPane().add(jtp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gridPanel1.setLayout(bigGrid);
		gridPanel2.setLayout(bottomGrid);
		gridPanel3.setLayout(topGrid);
		group.add(rbAll);
		group.add(rbBook);
		group.add(rbDVD);
		jp1.add(tab1);
		jp2.add(tab2);
		tab1.setName("Sökfält");
		tab2.setName("Lånade Böcker");		
		jp2.add(textArea2);
		jtp.addTab(tab1.getName(), jp1);
		jtp.addTab(tab2.getName(), jp2);
		gridPanel3.add(rbAll);
		gridPanel3.add(rbBook);
		gridPanel3.add(rbDVD);
		gridPanel1.add(gridPanel3, BorderLayout.WEST);	
		gridPanel1.add(searchField);
		gridPanel1.add(searchButton);

		
		
		frame.add(jtp, BorderLayout.CENTER);
		frame.add(gridPanel1,BorderLayout.SOUTH);
		jp1.add(textArea1);
		frame.pack();
		frame.setVisible(true);
	}
}
