package p3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SSPUserInput extends JPanel {
	private JButton btnSten = new JButton("Sten");
	private JButton btnSax = new JButton("Sax");
	private JButton btnBag = new JButton("Påse");
	private JButton btnNew = new JButton("Nytt Spel");
	private JButton btnAvsluta = new JButton("Avsluta");

	private JPanel panel = new JPanel();
	private JPanel pnlButton = new JPanel();

	private SSPController controller;

	public SSPUserInput(SSPController controller) {
		this.controller = controller;
		setPreferredSize(new Dimension(300, 200));
		pnlButton.setLayout(new GridLayout(1, 3));
		panel.setLayout(new GridLayout(2, 1));

		pnlButton.add(btnSten);
		pnlButton.add(btnSax);
		pnlButton.add(btnBag);

		panel.add(btnNew);
		panel.add(btnAvsluta);

		add(pnlButton, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		ButtonListener listner = new ButtonListener();

		btnSten.addActionListener(listner);
		btnSax.addActionListener(listner);
		btnBag.addActionListener(listner);

		btnAvsluta.addActionListener(listner);
		btnNew.addActionListener(listner);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnSten) {
				controller.UserSten();
			} else if (event.getSource() == btnSax) {
				controller.UserSax();
			} else if (event.getSource() == btnBag) {
				controller.UserBag();
			} else if (event.getSource() == btnAvsluta) {
				controller.endGame();
			} else if (event.getSource() == btnNew) {
				controller.newGame();
			}

		}
	}
}
