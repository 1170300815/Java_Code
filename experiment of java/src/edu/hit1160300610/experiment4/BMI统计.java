package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BMI统计 extends JDialog {
	private JTextField textField_Aver;
	private JTextField textField_Most;
	private JTextField textField_Middle;
	private JTextField textField_Fc;
	private JTextField textField_Aver1;
	private JTextField textField_Most1;
	private JTextField textField_Middle1;
	private JTextField textField_Fc1;
	private JTextField textField_Aver2;
	private JTextField textField_Most2;
	private JTextField textField_Middle2;
	private JTextField textField_Fc2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BMI统计 dialog = new BMI统计();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BMI统计() {
		setTitle("BMI统计");
		setBounds(100, 100, 697, 483);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 411, 681, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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
		
		JLabel lblBmi = new JLabel("BMI信息数据统计：");
		lblBmi.setBounds(10, 21, 184, 15);
		getContentPane().add(lblBmi);
		
		JLabel lblNewLabel = new JLabel("BMI的平均值：");
		lblNewLabel.setBounds(23, 68, 78, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BMI的众数：");
		lblNewLabel_1.setBounds(23, 104, 78, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("BMI的中值：");
		lblNewLabel_2.setBounds(23, 141, 78, 15);
		getContentPane().add(lblNewLabel_2);
		
		textField_Aver = new JTextField();
		textField_Aver.setBounds(111, 65, 83, 21);
		getContentPane().add(textField_Aver);
		textField_Aver.setColumns(10);
		double sum = 0;
		double aver = 0;
		int i;
		for (i = 0; i < students.size(); i++) {
			sum = sum + students.get(i).bmi;
		}
		
		textField_Most = new JTextField();
		textField_Most.setBounds(111, 101, 83, 21);
		getContentPane().add(textField_Most);
		textField_Most.setColumns(10);
		HashMap<Double, Integer> map = new HashMap<>();
		int num[] = new int[students.size()];
		double item[] = new double[students.size()];
		for (int i = 0; i < students.size(); i++) {
			item[i] = students.get(i).bmi;
		}
		for (int j = 0; j < students.size(); j++) {
			for (int h = 0; h < students.size(); h++) {
				if (item[j] == item[h]) {
					num[j]++;
				}
			}
		}
		for (int i = 0; i < students.size(); i++) {
			map.put(item[i], num[i]);
		}
		int temp = 0;
		for (int i = 0; i < students.size() - 1; i++) {
			if (num[i] < num[i + 1]) {
				temp = i + 1;
			}
		}
		if (num[temp] == 1) {
			System.out.println("众数不存在");
		} else {
			Set<Double> set = map.keySet();
			Iterator<Double> it = set.iterator();
			System.out.println("bmi的众数为： ");
			while (it.hasNext()) {
				double n = it.next();
				if (map.get(n) == num[temp]) {
					System.out.printf("%.2f", n);
					System.out.println();
				}
			}
		}
		
		textField_Middle = new JTextField();
		textField_Middle.setBounds(111, 138, 83, 21);
		getContentPane().add(textField_Middle);
		textField_Middle.setColumns(10);
		double a[] = new double[students.size()];
		for (int i = 0; i < students.size(); i++) {
			a[i] = students.get(i).bmi;
		}
		Arrays.sort(a);
		if (students.size() % 2 == 0) {
			textField_Middle.setText(Double.toString(a[(students.size() / 2)] + a[(students.size() / 2 - 1)]));
		} else {
			textField_Middle.setText(Double.toString(a[(students.size() - 1) / 2]));
		}
		
		JLabel lblNewLabel_3 = new JLabel("BMI的方差：");
		lblNewLabel_3.setBounds(23, 178, 78, 15);
		getContentPane().add(lblNewLabel_3);
		textField_Fc = new JTextField();
		textField_Fc.setBounds(111, 175, 83, 21);
		getContentPane().add(textField_Fc);
		textField_Fc.setColumns(10);
		
		JLabel label = new JLabel("身高的信息数据统计：");
		label.setBounds(252, 21, 128, 15);
		getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel("身高的平均值：");
		lblNewLabel_4.setBounds(326, 68, 101, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("身高的众数");
		lblNewLabel_5.setBounds(326, 104, 101, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("身高的中值：");
		lblNewLabel_6.setBounds(326, 141, 101, 15);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("身高的方差");
		lblNewLabel_7.setBounds(326, 178, 101, 15);
		getContentPane().add(lblNewLabel_7);
		
		textField_Aver1 = new JTextField();
		textField_Aver1.setBounds(455, 65, 101, 21);
		getContentPane().add(textField_Aver1);
		textField_Aver1.setColumns(10);
		
		textField_Most1 = new JTextField();
		textField_Most1.setBounds(455, 101, 101, 21);
		getContentPane().add(textField_Most1);
		textField_Most1.setColumns(10);
		
		textField_Middle1 = new JTextField();
		textField_Middle1.setBounds(455, 138, 101, 21);
		getContentPane().add(textField_Middle1);
		textField_Middle1.setColumns(10);
		
		textField_Fc1 = new JTextField();
		textField_Fc1.setBounds(455, 175, 101, 21);
		getContentPane().add(textField_Fc1);
		textField_Fc1.setColumns(10);
		
		JLabel label_1 = new JLabel("体重的信息数据统计：");
		label_1.setBounds(10, 225, 138, 15);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_8 = new JLabel("体重的平均值：");
		lblNewLabel_8.setBounds(23, 261, 91, 15);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("体重的众数：");
		lblNewLabel_9.setBounds(23, 297, 91, 15);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("体重的中值：");
		lblNewLabel_10.setBounds(23, 335, 91, 15);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("体重的方差：");
		lblNewLabel_11.setBounds(23, 367, 91, 15);
		getContentPane().add(lblNewLabel_11);
		
		textField_Aver2 = new JTextField();
		textField_Aver2.setBounds(111, 258, 83, 21);
		getContentPane().add(textField_Aver2);
		textField_Aver2.setColumns(10);
		
		textField_Most2 = new JTextField();
		textField_Most2.setBounds(111, 294, 83, 21);
		getContentPane().add(textField_Most2);
		textField_Most2.setColumns(10);
		
		textField_Middle2 = new JTextField();
		textField_Middle2.setBounds(111, 332, 83, 21);
		getContentPane().add(textField_Middle2);
		textField_Middle2.setColumns(10);
		
		textField_Fc2 = new JTextField();
		textField_Fc2.setBounds(111, 364, 83, 21);
		getContentPane().add(textField_Fc2);
		textField_Fc2.setColumns(10);
		double fc;
		double fc1 = 0;
		for (int i = 0; i < students.size(); i++) {
			fc1 = fc1 + (students.get(i).bmi - Averofbmi(students)) * (students.get(i).bmi - Averofbmi(students));
		}
		fc = fc1 / students.size();
	}
}
