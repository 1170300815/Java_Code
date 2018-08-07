package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class SwingBMI extends JFrame {
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

	public void genStudents(int n) {
		Random r = new Random();
		double x = 0.0, y = 0.0;
		for (int i = 0; i < n; i++) {
			x = r.nextGaussian();
			y = r.nextGaussian();
			if (isExists("i")) {
				continue;
			}
			Student st = new Student(String.format("%04d", i), genRandomString(6),
					((int) ((1.75 + x * 0.1) * 100)) / 100.0, ((int) ((60.0 + y * 5) * 100)) / 100.0);
			students.add(st);
		}

	}

	public void sortStudents(Comparator<Student> c) {
		Collections.sort(students, c);
	}

	class WeightComparator implements Comparator<Student> {
		public int compare(Student st1, Student st2) {
			if (st1.weight > st2.weight) {
				return 1;
			} else if (st1.weight < st2.weight) {
				return -1;
			}
			return 0;
		}
	}

	WeightComparator b = new WeightComparator();

	class BmiComparator implements Comparator<Student> {
		public int compare(Student st1, Student st2) {
			if (st1.bmi > st2.bmi) {
				return 1;
			} else if (st1.bmi < st2.bmi) {
				return -1;
			}
			return 0;
		}
	}

	BmiComparator c = new BmiComparator();

	class NameComparator implements Comparator<Student> {
		public int compare(Student st1, Student st2) {
			return st1.name.compareTo(st2.name);
		}
	}

	NameComparator d = new NameComparator();

	class Idcomparator implements Comparator<Student> {
		public int compare(Student st1, Student st2) {
			return st1.id.compareTo(st2.id);
		}
	}

	Idcomparator e = new Idcomparator();

	class HeightComparator implements Comparator<Student> {
		public int compare(Student st1, Student st2) {
			if (st1.height > st2.height) {
				return 1;
			} else if (st1.height < st2.height) {
				return -1;
			}
			return 0;
		}
	}

	HeightComparator a = new HeightComparator();

	public String genRandomString(int length) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(26);
			sb.append(str.charAt(number));
		}
		return sb.toString();
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
			return "學號： " + this.id + "     " + "姓名： " + this.name + "     " + "身高：" + this.height + "m" + "     "
					+ "體重： " + this.weight + "kg" + "     " + "bmi: " + this.bmi;
		}

	}

	private JPanel contentPane;
	private JTextField text_name;
	private JTextField text_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBMI frame = new SwingBMI();
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
	public SwingBMI() {

		setTitle("学生信息查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 481);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("菜单");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("学生信息修改");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modify dialog = new modify();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			}
		});
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("学生信息删除");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete dialog = new delete();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menu.add(menuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("学生信息输入");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input dialog = new input();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menu.add(mntmNewMenuItem);

		JMenuItem mntmBmi = new JMenuItem("Statistics");
		mntmBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statistics dialog = new Statistics();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		menu.add(mntmBmi);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(112, 86, 85, 35);
		contentPane.add(scrollPane_2);

		JTextArea textArea_name = new JTextArea();
		scrollPane_2.setViewportView(textArea_name);
		JButton button = new JButton("按姓名查询学生信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = text_name.getText();
				int i;
				for (i = 0; i < students.size(); i++) {
					if (ID.equals(students.get(i).name)) {
						textArea_name.setText(students.get(i).toString());
						break;
					}
				}
			}
		});
		button.setBounds(42, 22, 155, 23);
		contentPane.add(button);

		text_name = new JTextField();
		text_name.setBounds(102, 55, 95, 21);
		contentPane.add(text_name);
		text_name.setColumns(10);

		JLabel label = new JLabel("姓名：");
		label.setBounds(24, 55, 54, 15);
		contentPane.add(label);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(102, 201, 95, 35);
		contentPane.add(scrollPane_1);

		JTextArea textArea_id = new JTextArea();
		scrollPane_1.setViewportView(textArea_id);

		JButton btnNewButton = new JButton("按学生学号查血信息");
		btnNewButton.setBounds(42, 127, 155, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID = text_id.getText();
				for (int i = 0; i < students.size(); i++) {
					if (ID.equals(students.get(i).id)) {
						textArea_id.setText(students.get(i).toString());
						break;
					}
				}
			}
		});
		contentPane.add(btnNewButton);

		JLabel label_1 = new JLabel("学号：");
		label_1.setBounds(24, 173, 40, 15);
		contentPane.add(label_1);

		text_id = new JTextField();
		text_id.setBounds(102, 170, 95, 21);
		contentPane.add(text_id);
		text_id.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 10, 406, 401);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		genStudents(50);
		StringBuffer sb = new StringBuffer();
		for (Student st : students) {
			sb.append(st.toString()).append("\n");
		}
		textArea.setText(sb.toString());
		textArea.setEditable(false);

		JButton button_1 = new JButton("按身高排序学生");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortStudents(a);
				StringBuffer sb = new StringBuffer();
				for (Student st : students) {
					sb.append(st.toString()).append("\n");
				}
				textArea.setText(sb.toString());
				textArea.setEditable(false);
			}
		});
		button_1.setBounds(10, 246, 136, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("按体重排序学生");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortStudents(b);
				StringBuffer sb = new StringBuffer();
				for (Student st : students) {
					sb.append(st.toString()).append("\n");
				}
				textArea.setText(sb.toString());
				textArea.setEditable(false);
			}
		});
		button_2.setBounds(156, 246, 144, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("按姓名排序学生");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortStudents(d);
				StringBuffer sb = new StringBuffer();
				for (Student st : students) {
					sb.append(st.toString()).append("\n");
				}
				textArea.setText(sb.toString());
				textArea.setEditable(false);
			}
		});
		button_3.setBounds(10, 300, 136, 23);
		contentPane.add(button_3);

		JButton button_4 = new JButton("按学号排序学生");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortStudents(e);
				StringBuffer sb = new StringBuffer();
				for (Student st : students) {
					sb.append(st.toString()).append("\n");
				}
				textArea.setText(sb.toString());
				textArea.setEditable(false);
			}
		});
		button_4.setBounds(156, 300, 144, 23);
		contentPane.add(button_4);

		JButton btnbmi = new JButton("按bmi排序学生");
		btnbmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sortStudents(c);
				StringBuffer sb = new StringBuffer();
				for (Student st : students) {
					sb.append(st.toString()).append("\n");
				}
				textArea.setText(sb.toString());
				textArea.setEditable(false);
			}
		});
		btnbmi.setBounds(10, 354, 136, 23);
		contentPane.add(btnbmi);
		JLabel label_2 = new JLabel("所查找的学生：");
		label_2.setBounds(0, 93, 100, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("所查找的学生：");
		label_3.setBounds(0, 198, 100, 15);
		contentPane.add(label_3);

	}

	public class input extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField text_id;
		private JTextField text_name;
		private JTextField text_weight;
		private JTextField text_height;

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
						JOptionPane.showConfirmDialog(null, "该学生已存在，请重新输入");
					}
					String name = text_name.getText();
					String height = text_height.getText();
					String weight = text_weight.getText();
					Student on1 = new Student(id, name, Double.parseDouble(height), Double.parseDouble(weight));
					students.add(on1);
					JOptionPane.showConfirmDialog(null, "成功保存！");
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

	public class delete extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField textField_did;

		/**
		 * Create the dialog.
		 */
		public delete() {
			setTitle("删除学生信息");
			setBounds(100, 100, 722, 460);
			getContentPane().setLayout(null);
			contentPanel.setBounds(0, 0, 434, 20);
			contentPanel.setLayout(new FlowLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 388, 706, 33);
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
			{
				JButton button = new JButton("确认删除");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String index = textField_did.getText();
						if (isExists(index)) {
							students.remove(Integer.parseInt(index));
							JOptionPane.showConfirmDialog(null, "删除成功！");
						} else {
							JOptionPane.showConfirmDialog(null, "该学生不存在！");
						}
					}
				});
				button.setBounds(50, 108, 94, 23);
				getContentPane().add(button);
			}
			{
				textField_did = new JTextField();
				textField_did.setBounds(224, 43, 146, 21);
				getContentPane().add(textField_did);
				textField_did.setColumns(10);
			}
			{
				JLabel label = new JLabel("所删除学生的学号：");
				label.setBounds(50, 46, 120, 15);
				getContentPane().add(label);
			}
		}

	}

	public class modify extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField textField1_id;
		private JTextField textField__name;
		private JTextField textField__height;
		private JTextField textField__weight;
		private JTextField textField_mid;

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
						String id = textField_mid.getText();
						String name1 = textField__name.getText();
						students.get(Integer.parseInt(id)).name = name1;
					}
				});
				btnNewButton.setBounds(245, 232, 93, 23);
				contentPanel.add(btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("确认修改");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = textField_mid.getText();
						String height1 = textField__height.getText();
						students.get(Integer.parseInt(id)).height = Double.parseDouble(height1);
						students.get(Integer.parseInt(id)).bmi = ((int) ((students.get(Integer.parseInt(id)).weight)
								/ (Double.parseDouble(height1) * Double.parseDouble(height1)) * 100)) / 100.0;
					}
				});
				btnNewButton_1.setBounds(245, 263, 93, 23);
				contentPanel.add(btnNewButton_1);
			}
			{
				JButton btnNewButton_2 = new JButton("确认修改");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = textField_mid.getText();
						String weight1 = textField__weight.getText();
						students.get(Integer.parseInt(id)).weight = Double.parseDouble(weight1);
						students.get(Integer.parseInt(id)).bmi = ((int) (Double.parseDouble(weight1)
								/ (students.get(Integer.parseInt(id)).height
										* students.get(Integer.parseInt(id)).height)
								* 100)) / 100.0;
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

	public class Statistics extends JDialog {
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
		 * Create the dialog.
		 */
		public Statistics() {
			DecimalFormat df = new DecimalFormat("######0.00");
			setTitle("数据统计");
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
			double sum1 = 0.00;
			double aver1 = 0.00;
			int i1;
			for (i1 = 0; i1 < students.size(); i1++) {
				sum1 = sum1 + students.get(i1).height;
			}
			textField_Aver1.setText((df.format((sum1) / (double) i1)));

			textField_Most1 = new JTextField();
			textField_Most1.setBounds(455, 101, 101, 21);
			getContentPane().add(textField_Most1);
			textField_Most1.setColumns(10);
			HashMap<Double, Integer> map1 = new HashMap<>();
			int num2[] = new int[students.size()];
			double item2[] = new double[students.size()];
			for (int b1 = 0; b1 < students.size(); b1++) {
				item2[b1] = students.get(b1).height;
			}
			for (int j = 0; j < students.size(); j++) {
				for (int h = 0; h < students.size(); h++) {
					if (item2[j] == item2[h]) {
						num2[j]++;
					}
				}
			}
			for (int c1 = 0; c1 < students.size(); c1++) {
				map1.put(item2[c1], num2[c1]);
			}
			int temp2 = 0;
			for (int d1 = 0; d1 < students.size() - 1; d1++) {
				if (num2[d1] < num2[d1 + 1]) {
					temp2 = d1 + 1;
				}
			}
			if (num2[temp2] == 1) {
				textField_Most1.setText("众数不存在");
			} else {
				Set<Double> set = map1.keySet();
				Iterator<Double> it = set.iterator();
				while (it.hasNext()) {
					double n = it.next();
					if (map1.get(n) == num2[temp2]) {
						textField_Most1.setText(df.format(n));
					}
				}
			}

			textField_Middle1 = new JTextField();
			textField_Middle1.setBounds(455, 138, 101, 21);
			getContentPane().add(textField_Middle1);
			textField_Middle1.setColumns(10);
			double a3[] = new double[students.size()];
			for (int i11 = 0; i11 < students.size(); i11++) {
				a3[i11] = students.get(i11).height;
			}
			Arrays.sort(a3);
			if (students.size() % 2 == 0) {
				textField_Middle1.setText(df.format((a3[(students.size() / 2)] + a3[(students.size() / 2 - 1)]) / 2));
			} else {
				textField_Middle1.setText(df.format(a3[(students.size() - 1) / 2]));
			}

			textField_Fc1 = new JTextField();
			textField_Fc1.setBounds(455, 175, 101, 21);
			getContentPane().add(textField_Fc1);
			textField_Fc1.setColumns(10);
			double fc4;
			double fc5 = 0;
			for (int i11 = 0; i11 < students.size(); i11++) {
				fc5 = fc5 + (students.get(i11).height - (sum1) / (double) i1)
						* (students.get(i11).height - (sum1) / (double) i1);
			}
			fc4 = fc5 / students.size();
			textField_Fc1.setText(df.format(fc5));

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
			double sum2 = 0.00;
			double aver2 = 0.00;
			int i2;
			for (i2 = 0; i2 < students.size(); i2++) {
				sum2 = sum2 + students.get(i2).weight;
			}
			textField_Aver2.setText((df.format((sum2) / (double) i2)));

			textField_Most2 = new JTextField();
			textField_Most2.setBounds(111, 294, 83, 21);
			getContentPane().add(textField_Most2);
			textField_Most2.setColumns(10);
			HashMap<Double, Integer> map2 = new HashMap<>();
			int num1[] = new int[students.size()];
			double item1[] = new double[students.size()];
			for (int b2 = 0; b2 < students.size(); b2++) {
				item1[b2] = students.get(b2).weight;
			}
			for (int j = 0; j < students.size(); j++) {
				for (int h = 0; h < students.size(); h++) {
					if (item1[j] == item1[h]) {
						num1[j]++;
					}
				}
			}
			for (int c2 = 0; c2 < students.size(); c2++) {
				map2.put(item1[c2], num1[c2]);
			}
			int temp1 = 0;
			for (int d2 = 0; d2 < students.size() - 1; d2++) {
				if (num1[d2] < num1[d2 + 1]) {
					temp1 = d2 + 1;
				}
			}
			if (num1[temp1] == 1) {
				textField_Most2.setText("众数不存在");
			} else {
				Set<Double> set = map2.keySet();
				Iterator<Double> it = set.iterator();
				while (it.hasNext()) {
					double n = it.next();
					if (map2.get(n) == num1[temp1]) {
						textField_Most2.setText(df.format(n));
					}
				}
			}

			textField_Middle2 = new JTextField();
			textField_Middle2.setBounds(111, 332, 83, 21);
			getContentPane().add(textField_Middle2);
			textField_Middle2.setColumns(10);
			double a2[] = new double[students.size()];
			for (int i11 = 0; i11 < students.size(); i11++) {
				a2[i11] = students.get(i11).weight;
			}
			Arrays.sort(a2);
			if (students.size() % 2 == 0) {
				textField_Middle2.setText(df.format((a2[(students.size() / 2)] + a2[(students.size() / 2 - 1)]) / 2));
			} else {
				textField_Middle2.setText(df.format(a2[(students.size() - 1) / 2]));
			}

			textField_Fc2 = new JTextField();
			textField_Fc2.setBounds(111, 364, 83, 21);
			getContentPane().add(textField_Fc2);
			textField_Fc2.setColumns(10);
			double fc2;
			double fc3 = 0;
			for (int i11 = 0; i11 < students.size(); i11++) {
				fc3 = fc3 + (students.get(i11).weight - (sum2) / (double) i2)
						* (students.get(i11).weight - (sum2) / (double) i2);
			}
			fc2 = fc3 / students.size();
			textField_Fc2.setText(df.format(fc2));

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
			double sum = 0.00;
			double aver = 0.00;
			int i;
			for (i = 0; i < students.size(); i++) {
				sum = sum + students.get(i).bmi;
			}
			textField_Aver.setText((df.format((sum) / (double) i)));

			textField_Most = new JTextField();
			textField_Most.setBounds(111, 101, 83, 21);
			getContentPane().add(textField_Most);
			textField_Most.setColumns(10);
			HashMap<Double, Integer> map = new HashMap<>();
			int num[] = new int[students.size()];
			double item[] = new double[students.size()];
			for (int i11 = 0; i11 < students.size(); i11++) {
				item[i11] = students.get(i11).bmi;
			}
			for (int j = 0; j < students.size(); j++) {
				for (int h = 0; h < students.size(); h++) {
					if (item[j] == item[h]) {
						num[j]++;
					}
				}
			}
			for (int i11 = 0; i11 < students.size(); i11++) {
				map.put(item[i11], num[i11]);
			}
			int temp = 0;
			for (int i11 = 0; i11 < students.size() - 1; i11++) {
				if (num[i11] < num[i11 + 1]) {
					temp = i11 + 1;
				}
			}
			if (num[temp] == 1) {
				textField_Most.setText("众数不存在");
			} else {
				Set<Double> set = map.keySet();
				Iterator<Double> it = set.iterator();
				while (it.hasNext()) {
					double n = it.next();
					if (map.get(n) == num[temp]) {
						textField_Most.setText(df.format(n));
					}
				}
			}

			textField_Middle = new JTextField();
			textField_Middle.setBounds(111, 138, 83, 21);
			getContentPane().add(textField_Middle);
			textField_Middle.setColumns(10);
			double a[] = new double[students.size()];
			for (int i11 = 0; i11 < students.size(); i11++) {
				a[i11] = students.get(i11).bmi;
			}
			Arrays.sort(a);
			if (students.size() % 2 == 0) {
				textField_Middle.setText(df.format((a[(students.size() / 2)] + a[(students.size() / 2 - 1)]) / 2));
			} else {
				textField_Middle.setText(df.format(a[(students.size() - 1) / 2]));
			}

			JLabel lblNewLabel_3 = new JLabel("BMI的方差：");
			lblNewLabel_3.setBounds(23, 178, 78, 15);
			getContentPane().add(lblNewLabel_3);
			textField_Fc = new JTextField();
			textField_Fc.setBounds(111, 175, 83, 21);
			getContentPane().add(textField_Fc);
			textField_Fc.setColumns(10);
			double fc;
			double fc1 = 0;
			for (int i11 = 0; i11 < students.size(); i11++) {
				fc1 = fc1 + (students.get(i11).bmi - (sum) / (double) i) * (students.get(i11).bmi - (sum) / (double) i);
			}
			fc = fc1 / students.size();
			textField_Fc.setText(df.format(fc));
			JFreeChart chart = ChartFactory.createXYBarChart("BMI Statistics", "Intervals", false, "Number of Students",
					createDataset(), PlotOrientation.VERTICAL, true, false, false);

			ChartFrame frame = new ChartFrame("BMI Statistics", chart);
			frame.pack();
			frame.setVisible(true);

			JFreeChart chart1 = ChartFactory.createXYBarChart("Height Statistics", "Intervals", false,
					"Number of Students", createDataset1(), PlotOrientation.VERTICAL, true, false, false);

			ChartFrame frame1 = new ChartFrame("BMI Statistics", chart1);
			frame1.pack();
			frame1.setVisible(true);

			JFreeChart chart2 = ChartFactory.createXYBarChart("Weight Statistics", "Intervals", false,
					"Number of Students", createDataset2(), PlotOrientation.VERTICAL, true, false, false);

			ChartFrame frame2 = new ChartFrame("BMI Statistics", chart2);
			frame2.pack();
			frame2.setVisible(true);
		}

		public IntervalXYDataset createDataset() {
			int number[] = new int[10];
			double bmi[] = new double[students.size()];
			for (int i = 0; i < students.size(); i++) {
				bmi[i] = students.get(i).bmi;
			}
			Arrays.sort(bmi);
			double x = (bmi[bmi.length - 1] - bmi[0]) / 10.0;
			DivideStudent(x, bmi, number);
			XYSeriesCollection seriesCollection = new XYSeriesCollection();
			XYSeries series = new XYSeries("BMI Statistics");
			series.add(1, number[0]);
			series.add(2, number[1]);
			series.add(3, number[2]);
			series.add(4, number[3]);
			series.add(5, number[4]);
			series.add(6, number[5]);
			series.add(7, number[6]);
			series.add(8, number[7]);
			series.add(9, number[8]);
			series.add(10, number[9]);
			seriesCollection.addSeries(series);
			return new XYBarDataset(seriesCollection, 0.9);
		}

		public IntervalXYDataset createDataset1() {
			int number1[] = new int[10];
			double height[] = new double[students.size()];
			for (int i = 0; i < students.size(); i++) {
				height[i] = students.get(i).height;
			}
			Arrays.sort(height);
			double x = (height[height.length - 1] - height[0]) / 10.0;
			DivideStudent(x, height, number1);
			XYSeriesCollection seriesCollection = new XYSeriesCollection();
			XYSeries series1 = new XYSeries("Height Statistics");
			series1.add(1, number1[0]);
			series1.add(2, number1[1]);
			series1.add(3, number1[2]);
			series1.add(4, number1[3]);
			series1.add(5, number1[4]);
			series1.add(6, number1[5]);
			series1.add(7, number1[6]);
			series1.add(8, number1[7]);
			series1.add(9, number1[8]);
			series1.add(10, number1[9]);
			seriesCollection.addSeries(series1);
			return new XYBarDataset(seriesCollection, 0.9);
		}

		public IntervalXYDataset createDataset2() {
			int number2[] = new int[10];
			double weight[] = new double[students.size()];
			for (int i = 0; i < students.size(); i++) {
				weight[i] = students.get(i).weight;
			}
			Arrays.sort(weight);
			double x = (weight[weight.length - 1] - weight[0]) / 10.0;
			DivideStudent(x, weight, number2);
			XYSeriesCollection seriesCollection = new XYSeriesCollection();
			XYSeries series2 = new XYSeries("Weight Statistics");
			series2.add(1, number2[0]);
			series2.add(2, number2[1]);
			series2.add(3, number2[2]);
			series2.add(4, number2[3]);
			series2.add(5, number2[4]);
			series2.add(6, number2[5]);
			series2.add(7, number2[6]);
			series2.add(8, number2[7]);
			series2.add(9, number2[8]);
			series2.add(10, number2[9]);
			seriesCollection.addSeries(series2);
			return new XYBarDataset(seriesCollection, 0.9);
		}

		public void DivideStudent(double x, double students[], int number[]) {

			for (int i = 0; i < number.length; i++) {
				number[i] = 0;
			}
			for (int i = 0; i < students.length; i++) {
				if (students[i] >= students[0] && students[i] < students[0] + x) {
					number[0]++;
				}
				if (students[i] >= students[0] + x && students[i] < students[0] + 2 * x) {
					number[1]++;
				}
				if (students[i] >= students[0] + 2 * x && students[i] < students[0] + 3 * x) {
					number[2]++;
				}
				if (students[i] >= students[0] + 3 * x && students[i] < students[0] + 4 * x) {
					number[3]++;
				}
				if (students[i] >= students[0] + 4 * x && students[i] < students[0] + 5 * x) {
					number[4]++;
				}
				if (students[i] >= students[0] + 5 * x && students[i] < students[0] + 6 * x) {
					number[5]++;
				}
				if (students[i] >= students[0] + 6 * x && students[i] < students[0] + 7 * x) {
					number[6]++;
				}
				if (students[i] >= students[0] + 7 * x && students[i] < students[0] + 8 * x) {
					number[7]++;
				}
				if (students[i] >= students[0] + 8 * x && students[i] < students[0] + 9 * x) {
					number[8]++;
				}
				if (students[i] >= students[0] + 9 * x && students[i] < students[0] + 10 * x) {
					number[9]++;
				}
			}
		}

	}

}
