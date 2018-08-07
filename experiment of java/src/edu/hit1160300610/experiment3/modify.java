package edu.hit1160300610.experiment3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField1_id;
	private JTextField textField__name;
	private JTextField textField__height;
	private JTextField textField__weight;
	private JTextField textField_mid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			modify dialog = new modify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public modify() {
		setTitle("学生信息修改");
		setBounds(100, 100, 716, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("学生学号：");
			label.setBounds(32, 55, 70, 15);
			contentPanel.add(label);
		}
		{
			textField1_id = new JTextField();
			textField1_id.setBounds(110, 52, 126, 21);
			contentPanel.add(textField1_id);
			textField1_id.setColumns(10);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 39, 310, 45);
		contentPanel.add(scrollPane);
		
		JTextArea textArea_xx = new JTextArea();
		scrollPane.setViewportView(textArea_xx);
		
		JLabel label = new JLabel("学生信息：");
		label.setBounds(292, 55, 78, 15);
		contentPanel.add(label);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = textField1_id.getText();
				int i;
				for (i = 0; i < students.size(); i++) {
					if (ID.equals(students.get(i).id)) {
						textArea_xx.setText(students.get(i).toString());
						break;
					}
				}
			}
		});
		button.setBounds(24, 80, 93, 23);
		contentPanel.add(button);
		{
			JLabel label_1 = new JLabel("修改学生的姓名：");
			label_1.setBounds(21, 236, 96, 15);
			contentPanel.add(label_1);
		}
		{
			textField__name = new JTextField();
			textField__name.setBounds(145, 233, 78, 21);
			contentPanel.add(textField__name);
			textField__name.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("修改学生的升高：");
			lblNewLabel.setBounds(21, 267, 96, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("修改学生的体重：");
			lblNewLabel_1.setBounds(21, 298, 96, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField__height = new JTextField();
			textField__height.setBounds(145, 264, 78, 21);
			contentPanel.add(textField__height);
			textField__height.setColumns(10);
		}
		{
			textField__weight = new JTextField();
			textField__weight.setBounds(145, 295, 78, 21);
			contentPanel.add(textField__weight);
			textField__weight.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("确认修改");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=textField_mid.getText();
					String name1 = textField__name.getText();
					students.get(id).name = name1;
				}
			});
			btnNewButton.setBounds(245, 232, 93, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("确认修改");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=textField_mid.getText();
					String height1 = textField__height.getText();
					students.get(id).height = height1;
					students.get(id).bmi = ((int) ((students.get(id).weight) / (Double.parseDouble(height1) * Double.parseDouble(height1)) * 100)) / 100.0;
				}
			});
			btnNewButton_1.setBounds(245, 263, 93, 23);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("确认修改");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id=textField_mid.getText();
					String weight1 = textField__weight.getText();
					students.get(id).weight = weight1;
					students.get(id).bmi = ((int) (Double.parseDouble(weight1) / (students.get(id).height * students.get(id).height) * 100))
									/ 100.0;
				}
			});
			btnNewButton_2.setBounds(245, 294, 93, 23);
			contentPanel.add(btnNewButton_2);
		}
		{
			JLabel label_1 = new JLabel("修改学生的学号：");
			label_1.setBounds(21, 205, 96, 15);
			contentPanel.add(label_1);
		}
		{
			textField_mid = new JTextField();
			textField_mid.setBounds(145, 202, 78, 21);
			contentPanel.add(textField_mid);
			textField_mid.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
