package p3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SSPViewer extends JPanel {
	private String userPoint = "0";
	private String cpuPoint = "0";
	private String userChoice;
	private String cpuChoice;
	private JLabel bo3 = new JLabel("Först till tre vinner");

	private JPanel panel = new JPanel();

	private JLabel lbUser = new JLabel("User");
	private JLabel lbUserPoint = new JLabel(userPoint);
	private JLabel lbUserChoice = new JLabel(userChoice);

	private JLabel lbCPU = new JLabel("CPU");
	private JLabel lbPointCPU = new JLabel(cpuPoint);

	private JLabel lbCpuChoice = new JLabel(cpuChoice);

	public SSPViewer() {
		setPreferredSize(new Dimension(200, 130));
		panel.setLayout(new GridLayout(3, 2, 20, 20));

		panel.add(lbUser);
		panel.add(lbCPU);
		panel.add(lbUserChoice);
		panel.add(lbCpuChoice);
		panel.add(lbUserPoint);
		panel.add(lbPointCPU);

		bo3.setFont(new Font("SansSerif", Font.PLAIN, 20));

		add(bo3, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}

	public String getHumanPoint() {
		return lbUserPoint.getText();
	}

	public String getCPUPoint() {
		return lbPointCPU.getText();
	}

	public void setUserPoint(String point) {
		lbUserPoint.setText(point);
	}

	public void setCPUPoint(String pointCPU) {
		lbPointCPU.setText(pointCPU);
	}

	public String getHumanVerk() {
		return lbUserChoice.getText();
	}

	public String getCPUVerk() {
		return lbCpuChoice.getText();
	}

	public void setHumanVerk(String humanVerk) {
		lbUserChoice.setText(humanVerk);
	}

	public void setCPUVerk(String verkCPU) {
		lbCpuChoice.setText(verkCPU);
	}
}
