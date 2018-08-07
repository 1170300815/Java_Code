package edu.hit1160300610.experiment3;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class OOBMIg extends JFrame {
	



	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOBMIg frame = new OOBMIg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OOBMIg() {
		JMenuBar menu = new JMenuBar();
		JMenu opMenu = new JMenu("Operations");
		JMenuItem listitem = new JMenuItem("List students");
		listitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudetns();			
			}
		});
		opMenu.add(listitem);
		private void showStudetns(){
			this.setContentPane(new resultPanel());
			setVisible(true);
		}
		class resultPanel extends JPanel{
			public resultPanel() {
				JTextArea ta= new JTextArea("",20,40);
				ArrayList<Student> alst= Student.genTestStudents();
				StringBuffer sb = new StringBuffer();
				for(Student st: alst){
					sb.append(st.toString()).append("\n");
				}
				ta.setText(sb.toString());
				ta.setEditable(false);	
				JScrollPane sp=new JScrollPane(ta);
				sp.setBounds(5, 5, 500, 300);
				sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
				this.add(sp);
			}
		}



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
