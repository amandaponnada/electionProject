package electionProject;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class electionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame electionMaster = new JFrame();
		JPanel electionViewPanel = new electionView();
		electionMaster.add(electionViewPanel);
		
		electionMaster.setSize(600, 400);
		electionMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		electionMaster.setVisible(true);
	}

}
