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

import electionProject.electionVote.candidateListener;

public class electionResults extends JPanel {

	static String winningCandidate;
	
	public electionResults(electionDB rDB) {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());
		
		
        JLabel resultsTitle = new JLabel(rDB.getElectionName());
        JLabel winnerName = new JLabel("WINNER IS : " + rDB.electionWinner());
        JButton back = new JButton("BACK");
        
       //Create the radio buttons.
       JRadioButton candidate1Button = new JRadioButton(rDB.geteCandidate1Name() + " : " + rDB.geteCandidate1Votes());
       candidate1Button.setMnemonic(KeyEvent.VK_B);
       candidate1Button.setActionCommand(rDB.geteCandidate1Name());
      // candidate1Button.setSelected(true);

       JRadioButton candidate2Button = new JRadioButton(rDB.geteCandidate2Name() + " : " + rDB.geteCandidate2Votes());
       candidate2Button.setMnemonic(KeyEvent.VK_C);
       candidate2Button.setActionCommand(rDB.geteCandidate2Name());

       JRadioButton candidate3Button = new JRadioButton(rDB.geteCandidate3Name() + " : " + rDB.geteCandidate3Votes());
       candidate3Button.setMnemonic(KeyEvent.VK_D);
       candidate3Button.setActionCommand(rDB.geteCandidate3Name());

       //Group the radio buttons.
       ButtonGroup group = new ButtonGroup();
       group.add(candidate1Button);
       group.add(candidate2Button);
       group.add(candidate3Button);

       
       //Put the radio buttons in a column in a panel.
       JPanel votePanel = new JPanel(new GridLayout(0, 1));
       
       
       votePanel.add(resultsTitle);
       votePanel.add(candidate1Button);
       votePanel.add(candidate2Button);
       votePanel.add(candidate3Button);
       votePanel.add(winnerName);
       votePanel.add(back);
 
       add(votePanel, BorderLayout.LINE_START);
       votePanel.setVisible(true);
       
       back.addActionListener(new ActionListener() {

	   		@Override
	   		public void actionPerformed(ActionEvent e) {
	   			// TODO Auto-generated method stub
	   			
	   			if(e.getSource()==back) {
	   				removeAll();
	   				JPanel newPanel = new electionView();
	   				add(newPanel);
	   				revalidate();
	   				//newPanel.repaint();
	   			}
	   			
	   		}
       });	
}
    
}
