package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.hit1160300610.experiment3.OOBMI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class input extends JDialog {
	public ArrayList<Student> students = new ArrayList<>();
	public boolean isExists(String id) {
		if (students == null) {
			return false;
		} else {
			for (Student s : students) {
				if (s.id.equals(id)) {
					return true;
				}
			}
			return false;
		}
	}
	class Student {
		private String id;
		private String name;
		private double weight; // in kilograms
		private double height; // in meters
		private double bmi;

		public Student(String id, String name, double height, double weight) {
			this.id = id;
			this.name = name;
			this.height = height;
			this.weight = weight;
			this.bmi = ((int) ((weight / (height * height)) * 100)) / 100.00;
		}

		public String toString() {
			return "學號： " + this.id + "     " + "姓名： " + this.name + "     " + "身高：" + this.height + "m" + "     " + "體重： "
					+ this.weight + "kg" + "     " + "bmi: " + this.bmi;
		}

	}

	private final JPanel contentPanel = new JPanel();
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_weight;
	private JTextField text_height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			input dialog = new input();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public input() {
		setTitle("学生信息输入界面");
		setBounds(100, 100, 740, 475);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("学生学号：");
		label.setBounds(33, 27, 92, 15);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("学生姓名：");
		label_1.setBounds(33, 70, 92, 15);
		contentPanel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("学生体重：");
		lblNewLabel.setBounds(33, 109, 92, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学生身高：");
		lblNewLabel_1.setBounds(33, 150, 92, 15);
		contentPanel.add(lblNewLabel_1);
		
		text_id = new JTextField();
		text_id.setBounds(180, 24, 109, 21);
		contentPanel.add(text_id);
		text_id.setColumns(10);
		
		text_name = new JTextField();
		text_name.setBounds(180, 67, 109, 21);
		contentPanel.add(text_name);
		text_name.setColumns(10);
		
		text_weight = new JTextField();
		text_weight.setBounds(180, 106, 109, 21);
		contentPanel.add(text_weight);
		text_weight.setColumns(10);
		
		text_height = new JTextField();
		text_height.setBounds(180, 147, 109, 21);
		contentPanel.add(text_height);
		text_height.setColumns(10);
		
		JButton button = new JButton("保存学生");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = text_id.getText();
				if (isExists(id)) {
					int result=JOptionPane.showConfirmDialog(null, "该学生已存在，请重新输入");
				}
				String name = text_name.getText();
				System.out.println("輸入學生身高(m)");
				String height = text_height.getText();
				System.out.println("輸入學生體重(kg)");
				String weight = text_weight.getText();
				input on = new input();
				Student on1 = on.new Student(id, name, Double.parseDouble(height), Double.parseDouble(weight));
				students.add(on1);
			}
		});
		button.setBounds(32, 194, 93, 23);
		contentPanel.add(button);
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
