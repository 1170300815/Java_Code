package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;

public class OOBMI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOBMI frame = new OOBMI();
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
	public OOBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 100, 100);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("学生信息查询界面");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 121, 100, 100);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("学生信息输入界面");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(136, 10, 100, 100);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("学生信息修改界面");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(136, 121, 100, 100);
		contentPane.add(panel_3);
		
		JLabel label = new JLabel("学生信息删除界面");
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(274, 10, 138, 215);
		contentPane.add(panel_4);
		
		JLabel lblBmi = new JLabel("BMI统计界面");
		panel_4.add(lblBmi);
	}
}
