package edu.hit1160300610.experiment4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.io.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class OOBMI2 extends JFrame {
	OOBMI2 x=new OOBMI2();
	
	public ArrayList<Student> students = new ArrayList<>();
	class resultPanel extends JPanel{
		public resultPanel() {
			JTextArea ta= new JTextArea("",20,40);
			ArrayList<Student> alst= Student.genStudents();
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
			return "學號： " + this.id + "\t" + "姓名： " + this.name + "\t" + "身高：" + this.height + "m" + "\t" + "體重： "
					+ this.weight + "kg" + "\t" + "bmi: " + this.bmi;
		}
		public  ArrayList<Student> genStudents() {
			Random r = new Random();
			double x = 0.0, y = 0.0;
			for (int i = 0; i < 20; i++) {
				x = r.nextGaussian();
				y = r.nextGaussian();
				if (isExists("i")) {
					continue;
				}
				Student st = new Student(String.format("%04d", i), genRandomString(6),
						((int) ((1.75 + x * 0.1) * 100)) / 100.0, ((int) ((60.0 + y * 5) * 100)) / 100.0);
				students.add(st);
				
			}
			return students;

		}

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

	}
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OOBMI2 frame = new OOBMI2();
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
	public OOBMI2() {
		


		setTitle("学生信息查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menu = new JMenuBar();
		JMenu opMenu = new JMenu("Operations");
		JMenuItem listitem = new JMenuItem("List students");
		listitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStudetns();			
			}
			private void showStudetns(){
				this.setContentPane(new resultPanel());
				setVisible(true);
			}
		});
		

	}

	// public int findStudent(ArrayList<Student> students) {
	// String ID = text_id.getText();
	// int i;
	// for (i = 0; i < students.size(); i++) {
	// if (ID.equals(students.get(i).id)) {
	// textField.setText(students.get(i).toString());
	// break;
	// }
	// }
	// return i;
	// }

	// public void modifyStudent(ArrayList<Student> students, int index) {
	// System.out.println("修改姓名：1；修改身高：2；修改体重：3");
	// Scanner in = new Scanner(System.in);
	// int choice = in.nextInt();
	// if (choice == 1) {
	// System.out.println("将姓名修改为：");
	// String name1 = in.next();
	// students.get(index).name = name1;
	// }
	// if (choice == 2) {
	// System.out.println("将身高修改为：");
	// double height1 = in.nextDouble();
	// students.get(index).height = height1;
	// students.get(index).bmi = ((int) ((students.get(index).weight) / (height1 *
	// height1) * 100)) / 100.0;
	//
	// }
	// if (choice == 3) {
	// System.out.println("将体重修改为：");
	// double weight1 = in.nextDouble();
	// students.get(index).weight = weight1;
	// students.get(
	// index).bmi = ((int) ((weight1) / (students.get(index).height *
	// students.get(index).height) * 100))
	// / 100.0;
	// }
	// }

	// public void deleteStudent(ArrayList<Student> students, int index) {
	// students.remove(index);
	// }
	//
	// public void saveFile(ArrayList<Student> students, String filename) {
	// File file = new File("Stu.txt");
	// try {
	// FileWriter out = new FileWriter(file, false);
	// for (Student st : students) {
	// out.write(String.format("%s,%s,%.2f,%.2f,%.2f\r\n", st.id, st.name,
	// st.height, st.weight, st.bmi));
	// }
	// out.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public ArrayList<Student> readFile(String fileName) {
	// File file = new File("Stu.txt");
	// BufferedReader reader = null;
	// ArrayList<Student> v = new ArrayList<Student>();
	// try {
	// reader = new BufferedReader(new FileReader(file));
	// String s = null;
	// while ((s = reader.readLine()) != null) {
	// String a[] = s.split(",");
	// Student st = new Student(a[0], a[1], Double.parseDouble(a[2]),
	// Double.parseDouble(a[3]));
	// v.add(st);
	// }
	// reader.close();
	// return v;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return v;
	// }

	// public void sortStudents(Comparator<Student> c) {
	// Collections.sort(students, c);
	// }

	// class HeightComparator implements Comparator<Student> {
	// public int compare(Student st1, Student st2) {
	// if (st1.height > st2.height) {
	// return 1;
	// } else if (st1.height < st2.height) {
	// return -1;
	// }
	// return 0;
	// }
	// }

	// HeightComparator a = new HeightComparator();
	//
	// class WeightComparator implements Comparator<Student> {
	// public int compare(Student st1, Student st2) {
	// if (st1.weight > st2.weight) {
	// return 1;
	// } else if (st1.weight < st2.weight) {
	// return -1;
	// }
	// return 0;
	// }
	// }

	// WeightComparator b = new WeightComparator();
	//
	// class BmiComparator implements Comparator<Student> {
	// public int compare(Student st1, Student st2) {
	// if (st1.bmi > st2.bmi) {
	// return 1;
	// } else if (st1.bmi < st2.bmi) {
	// return -1;
	// }
	// return 0;
	// }
	// }
	//
	// BmiComparator c = new BmiComparator();
	//
	// class NameComparator implements Comparator<Student> {
	// public int compare(Student st1, Student st2) {
	// return st1.name.compareTo(st2.name);
	// }
	// }

	// NameComparator d = new NameComparator();
	//
	// class Idcomparator implements Comparator<Student> {
	// public int compare(Student st1, Student st2) {
	// return st1.id.compareTo(st2.id);
	// }
	// }

	// Idcomparator e = new Idcomparator();

	// public double Averofbmi(ArrayList<Student> students) {
	// double sum = 0;
	// double aver = 0;
	// int i;
	// for (i = 0; i < students.size(); i++) {
	// sum = sum + students.get(i).bmi;
	// }
	// return aver = sum / (double) i;
	// }
	//
	// public double Fchaofbmi(ArrayList<Student> students) {
	// double fc;
	// double fc1 = 0;
	// for (int i = 0; i < students.size(); i++) {
	// fc1 = fc1 + (students.get(i).bmi - Averofbmi(students)) *
	// (students.get(i).bmi - Averofbmi(students));
	// }
	// fc = fc1 / students.size();
	// return fc;
	// }
	//
	// public void Mostofbmi(ArrayList<Student> students) {
	// HashMap<Double, Integer> map = new HashMap<>();
	// int num[] = new int[students.size()];
	// double item[] = new double[students.size()];
	// for (int i = 0; i < students.size(); i++) {
	// item[i] = students.get(i).bmi;
	// }
	// for (int j = 0; j < students.size(); j++) {
	// for (int h = 0; h < students.size(); h++) {
	// if (item[j] == item[h]) {
	// num[j]++;
	// }
	// }
	// }
	// for (int i = 0; i < students.size(); i++) {
	// map.put(item[i], num[i]);
	// }
	// int temp = 0;
	// for (int i = 0; i < students.size() - 1; i++) {
	// if (num[i] < num[i + 1]) {
	// temp = i + 1;
	// }
	// }
	// if (num[temp] == 1) {
	// System.out.println("众数不存在");
	// } else {
	// Set<Double> set = map.keySet();
	// Iterator<Double> it = set.iterator();
	// System.out.println("bmi的众数为： ");
	// while (it.hasNext()) {
	// double n = it.next();
	// if (map.get(n) == num[temp]) {
	// System.out.printf("%.2f", n);
	// System.out.println();
	// }
	// }
	// }
	// }
	//
	// public double Medianofbmi(ArrayList<Student> students) {
	// double a[] = new double[students.size()];
	// for (int i = 0; i < students.size(); i++) {
	// a[i] = students.get(i).bmi;
	// }
	// Arrays.sort(a);
	// if (students.size() % 2 == 0) {
	// return a[(students.size() / 2)] + a[(students.size() / 2 - 1)];
	// } else {
	// return a[(students.size() - 1) / 2];
	// }
	// }
	//
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
	//
	// public void inputStudent() {
	// System.out.println("从键盘输入学生信息");
	// Scanner in = new Scanner(System.in);
	// System.out.println("輸入學生學號");
	// String id = in.nextLine();
	// if (isExists(id)) {
	// System.out.println("學號輸入重複,請換一個學號輸入");
	// id = in.nextLine();
	// }
	// System.out.println("輸入學生姓名");
	// String name = in.nextLine();
	// System.out.println("輸入學生身高(m)");
	// double height = in.nextDouble();
	// System.out.println("輸入學生體重(kg)");
	// double weight = in.nextDouble();
	// OOBMI2 on = new OOBMI2();
	// Student on1 = on.new Student(id, name, height, weight);
	// students.add(on1);
	// }
	//

	//
	// public void printStatics(ArrayList<Student> students) {
	// for (Student i : students) {
	// textField.setText(i.toString());
	// }
	// double aver = Averofbmi(students);
	// System.out.print("bmi的平均值是： ");
	// System.out.printf("%.2f", aver);
	// double middle = Medianofbmi(students);
	// System.out.println();
	// System.out.print("bmi的中值是： ");
	// System.out.printf("%.2f", middle);
	// System.out.println("");
	// Mostofbmi(students);
	// double fc = Fchaofbmi(students);
	// System.out.print("bmi的方差是： ");
	// System.out.printf("%.2f", fc);

	// }
}
