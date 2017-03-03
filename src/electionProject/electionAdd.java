package electionProject;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class electionAdd extends JPanel {
	
	JLabel addTitle = new JLabel("Add a new Election");
	JLabel electionLabel = new JLabel("Election Name");
	JTextField electionName = new JTextField(25);
	JLabel c1Label = new JLabel("1st Candidate Name");
	JTextField candidateName1 = new JTextField(25);
	JLabel c2Label = new JLabel("2nd Candidate Name");
	JTextField candidateName2 = new JTextField(25);
	JLabel c3Label = new JLabel("3rd Candidate Name");
	JTextField candidateName3 = new JTextField(25);
	
	
	JButton back = new JButton("Back");
	JButton add = new JButton("CREATE NEW ELECTION");
	
	
	public electionAdd() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		ButtonListener addButton = new ButtonListener();
		back.addActionListener(addButton);
		add.addActionListener(addButton);
		
		addTitle.setFont(new Font("Serif", Font.BOLD, 14));
		add(addTitle, BorderLayout.NORTH);
		
		JPanel electionLabels = new JPanel(new GridLayout(0,1));
		JPanel electionTextAreas = new JPanel(new GridLayout(0,1));
		electionLabels.add(electionLabel);
		electionTextAreas.add(electionName);
		electionLabels.add(c1Label);
		electionTextAreas.add(candidateName1);
		electionLabels.add(c2Label);
		electionTextAreas.add(candidateName2);
		electionLabels.add(c3Label);
		electionTextAreas.add(candidateName3);
		
		add(electionLabels, BorderLayout.WEST);
		add(electionTextAreas, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(add);
		buttonPanel.add(back);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == add) {
				System.out.println("Adding a new Election to DB");
				int tempEID;
				String tempEName;
				String tempeC1Name;
				String tempeC2Name;
				String tempeC3Name;

				Random rand = new Random();
				int rand_eid = rand.nextInt(1000) + 1;

				tempEID = rand_eid;
				System.out.println("Election _ ID : " + rand_eid);
				tempEName = electionName.getText();
				tempeC1Name = candidateName1.getText();
				tempeC2Name = candidateName2.getText();
				tempeC3Name = candidateName3.getText();
			
				electionDB newElection = new electionDB(tempEID, tempEName, tempeC1Name, tempeC2Name, tempeC3Name);
				electionDAO eDAO = new electionDAO();
				eDAO.insertNewElection(newElection);
				
				electionName.setEditable(false);
				candidateName1.setEditable(false);
				candidateName2.setEditable(false);
				candidateName3.setEditable(false);
				
				add.setVisible(false);
				revalidate();
			}
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new electionView();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
		}
		
	}
	
}
