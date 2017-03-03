package electionProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class electionVote extends JPanel {

    static String candidate1;
    static String candidate2;
    static String candidate3;
    static String voteNow  = "Vote Now";

    electionDAO cDAO = new electionDAO();
   
	public electionVote(int e_id) {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());
		
		electionDB cDB = cDAO.getAllCanddidates(e_id); 
		
        JLabel voteTitle = new JLabel(cDB.getElectionName());
        JButton voteButton = new JButton(voteNow);
        JButton voteResults = new JButton("Results");
        JButton back = new JButton("BACK");
        candidateListener checkCandidate = new candidateListener();
        
       //Create the radio buttons.
       JRadioButton candidate1Button = new JRadioButton(cDB.geteCandidate1Name());
       candidate1Button.setMnemonic(KeyEvent.VK_B);
       candidate1Button.setActionCommand(cDB.geteCandidate1Name());
      // candidate1Button.setSelected(true);

       JRadioButton candidate2Button = new JRadioButton(cDB.geteCandidate2Name());
       candidate2Button.setMnemonic(KeyEvent.VK_C);
       candidate2Button.setActionCommand(cDB.geteCandidate2Name());

       JRadioButton candidate3Button = new JRadioButton(cDB.geteCandidate3Name());
       candidate3Button.setMnemonic(KeyEvent.VK_D);
       candidate3Button.setActionCommand(cDB.geteCandidate3Name());

       //Group the radio buttons.
       ButtonGroup group = new ButtonGroup();
       group.add(candidate1Button);
       group.add(candidate2Button);
       group.add(candidate3Button);

       //Register a listener for the radio buttons.
       candidate1Button.addActionListener(checkCandidate);
       candidate2Button.addActionListener(checkCandidate);
       candidate3Button.addActionListener(checkCandidate);

       //Put the radio buttons in a column in a panel.
       JPanel votePanel = new JPanel(new GridLayout(0, 1));
       
       
       votePanel.add(voteTitle);
       votePanel.add(candidate1Button);
       votePanel.add(candidate2Button);
       votePanel.add(candidate3Button);
       votePanel.add(voteButton);
       votePanel.add(voteResults);
     
       add(votePanel, BorderLayout.LINE_START);
       votePanel.setVisible(true);
       
       //setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
      
       voteButton.addActionListener(new ActionListener() {

	   		@Override
	   		public void actionPerformed(ActionEvent arg0) {
	   			// TODO Auto-generated method stub
					cDB.eInitialize();
					electionDB cDB = cDAO.getAllCanddidates(e_id);
	   				if (candidate1Button.isSelected()) {
	   						cDB.seteCandidate1Votes(cDB.geteCandidate1Votes()+1);
	   			   			cDAO.updateCandidates(cDB);	   						
	   			   			JOptionPane.showMessageDialog(votePanel, "Thank You for your Vote", cDB.getElectionName(), JOptionPane.INFORMATION_MESSAGE);
		     			} else if (candidate2Button.isSelected()) {
	   						cDB.seteCandidate2Votes(cDB.geteCandidate2Votes()+1);
	   			   			cDAO.updateCandidates(cDB);	   						
		     				JOptionPane.showMessageDialog(votePanel, "Thank You for your Vote", cDB.getElectionName(), JOptionPane.INFORMATION_MESSAGE);
		     			} else if (candidate3Button.isSelected()) {
	   						cDB.seteCandidate3Votes(cDB.geteCandidate3Votes()+1);
	   			   			cDAO.updateCandidates(cDB);	   						
		     				JOptionPane.showMessageDialog(votePanel, "Thank You for your Vote", cDB.getElectionName(), JOptionPane.INFORMATION_MESSAGE);
		     			} else {
		     				JOptionPane.showMessageDialog(votePanel, "NO SELECTION MADE", cDB.getElectionName(), JOptionPane.WARNING_MESSAGE);
		     			}
					cDB = cDAO.getAllCanddidates(e_id);
	   				group.clearSelection();
	   		}
       });


       voteResults.addActionListener(new ActionListener() {

	   		@Override
	   		public void actionPerformed(ActionEvent arg0) {
	   			// TODO Auto-generated method stub
				electionDB cDB = cDAO.getAllCanddidates(e_id);
	   			removeAll();
	   			JPanel newPanel = new electionResults(cDB);
	   			add(newPanel);
	   			revalidate();
	   			newPanel.repaint();
	   		}
       });	
}
    
    class candidateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

    }

}