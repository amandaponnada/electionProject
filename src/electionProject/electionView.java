package electionProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class electionView extends JPanel{
	
	JButton add = new JButton("Add a new Election");
	JButton list = new JButton("View Available Election");
	

	public electionView() {
		// TODO Auto-generated constructor stub
		
		add(add);
		add(list);
		
		ButtonHandler eButtonHandler = new ButtonHandler();
		add.addActionListener(eButtonHandler);
		list.addActionListener(eButtonHandler);
		
	}
	
	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == add) {
				removeAll();
				JPanel newPanel = new electionAdd();
				add(newPanel);
				revalidate();
			}
			if (e.getSource() == list) {
				removeAll();
				JPanel newPanel = new electionList();
				add(newPanel);
				revalidate();
			}
		}
		
	}
	

}
