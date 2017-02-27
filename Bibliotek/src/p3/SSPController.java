package p3;

import java.util.Random;
import javax.swing.JOptionPane;

public class SSPController {
	private SSPViewer viewer;
	private SSPPlayer cpu;
	int userPoint = 0;
	int pointCPU = 0;
	Random rand = new Random();

	public SSPController(SSPViewer viewer, SSPPlayer cpu) {
		this.viewer = viewer;
		this.cpu = cpu;
	}

	public void newGame() {
		viewer.setUserPoint("0");
		viewer.setCPUPoint("0");
		viewer.setCPUVerk("");
		viewer.setHumanVerk("");
		userPoint = 0;
		pointCPU = 0;
	}

	public void endGame() {
		System.exit(0);
	}

	public void UserSten() {
		int r = rand.nextInt(3) + 0;
		if (cpu.newChoice(r) == 2) {
			userPoint += 1;
			viewer.setUserPoint((Integer.toString(userPoint)));
			viewer.setHumanVerk("Sten");
			viewer.setCPUVerk("Sax");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		} else if (cpu.newChoice(r) == 0) {
			viewer.setHumanVerk("Sten");
			viewer.setCPUVerk("Sten");
		} else {
			pointCPU += 1;
			viewer.setCPUPoint(Integer.toString(pointCPU));
			viewer.setHumanVerk("Sten");
			viewer.setCPUVerk("Påse");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		}
	}

	public void UserSax() {
		int r = rand.nextInt(3) + 0;
		if (cpu.newChoice(r) == 2) {
			userPoint += 1;
			viewer.setUserPoint((Integer.toString(userPoint)));
			viewer.setHumanVerk("Sax");
			viewer.setCPUVerk("Påse");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		} else if (cpu.newChoice(r) == 1) {
			viewer.setHumanVerk("Sax");
			viewer.setCPUVerk("Sax");
			viewer.setCPUPoint(Integer.toString(pointCPU));
			viewer.setUserPoint(Integer.toString(userPoint));
		} else if (cpu.newChoice(r) == 0) {
			pointCPU += 1;
			viewer.setCPUPoint(Integer.toString(pointCPU));
			viewer.setHumanVerk("Sax");
			viewer.setCPUVerk("Sten");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		}
	}

	public void UserBag() {
		int r = rand.nextInt(3) + 0;
		if (cpu.newChoice(r) == 0) {
			userPoint += 1;
			viewer.setUserPoint((Integer.toString(userPoint)));
			viewer.setHumanVerk("Påse");
			viewer.setCPUVerk("Sten");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		} else if (cpu.newChoice(r) == 2) {
			viewer.setHumanVerk("Påse");
			viewer.setCPUVerk("Påse");
		} else {
			pointCPU += 1;
			viewer.setCPUPoint(Integer.toString(pointCPU));
			viewer.setHumanVerk("Påse");
			viewer.setCPUVerk("Sax");
			if ((userPoint == 3)) {
				JOptionPane.showMessageDialog(null, "Du vann");
				newGame();
			} else if (pointCPU == 3) {
				JOptionPane.showMessageDialog(null, "CPU vann");
				newGame();
			}
		}
	}
}