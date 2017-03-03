package electionProject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class electionList extends JPanel {
	Container c = getRootPane();
	
	JLabel eListTitle = new JLabel("VIEW ELECTION LIST");
	electionDAO eDAO = new electionDAO();
	
	JButton back = new JButton("BACK");
	JButton vote = new JButton("VOTE");
	
	JList eList;
	ArrayList<electionDB> electionLists = eDAO.getAllElections();
	
	public electionList() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		eListTitle.setFont(new Font("Serif", Font.PLAIN, 16));
		
		eList = new JList(electionLists.toArray());
		
		JScrollPane eScroll = new JScrollPane(eList);
		
		eScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		eScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		eScroll.setPreferredSize(new Dimension(400,100));
		
		
		add(eListTitle, BorderLayout.NORTH);
		add(eScroll, BorderLayout.CENTER);
		
		ButtonListener eListener = new ButtonListener();
		back.addActionListener(eListener);
		vote.addActionListener(eListener);
		
		JPanel eButtonPanel = new JPanel();
		
		eButtonPanel.add(back);
		eButtonPanel.add(vote);
		
		add(eButtonPanel, BorderLayout.SOUTH);
		
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if (e.getSource() == back) {
				removeAll();
				JPanel newPanel = new electionView();
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
			
			if(e.getSource() == vote) {
				removeAll();
				int eIndex = eList.getSelectedIndex();
				electionDB tempEDB = electionLists.get(eIndex);
				System.out.println("Election ID : " + tempEDB.getElectionID());
				JPanel newPanel = new electionVote(tempEDB.getElectionID());
				add(newPanel);
				revalidate();
				newPanel.repaint();
			}
		}
		
	}
	
}
