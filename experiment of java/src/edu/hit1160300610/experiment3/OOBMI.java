package edu.hit1160300610.experiment3;

import java.util.*;
import java.io.*;

public class OOBMI {
	public ArrayList<Student> students = new ArrayList<>();

	public class Student {
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

	}

	public int findStudent(ArrayList<Student> students) {
		System.out.println("请输入你要查找学生的学号");
		Scanner in = new Scanner(System.in);
		String ID = in.nextLine();
		int i;
		for (i = 0; i < students.size(); i++) {
			if (ID.equals(students.get(i).id)) {
				System.out.println(students.get(i).toString());
				break;
			}
		}
		return i;
	}

	public void modifyStudent(ArrayList<Student> students, int index) {
		System.out.println("修改姓名：1；修改身高：2；修改体重：3");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if (choice == 1) {
			System.out.println("将姓名修改为：");
			String name1 = in.next();
			students.get(index).name = name1;
		}
		if (choice == 2) {
			System.out.println("将身高修改为：");
			double height1 = in.nextDouble();
			students.get(index).height = height1;
			students.get(index).bmi = ((int) ((students.get(index).weight) / (height1 * height1) * 100)) / 100.0;

		}
		if (choice == 3) {
			System.out.println("将体重修改为：");
			double weight1 = in.nextDouble();
			students.get(index).weight = weight1;
			students.get(
					index).bmi = ((int) ((weight1) / (students.get(index).height * students.get(index).height) * 100))
							/ 100.0;
		}
	}

	public void deleteStudent(ArrayList<Student> students, int index) {
		students.remove(index);
	}

	public void saveFile(ArrayList<Student> students, String filename) {
		File file = new File("Stu.txt");
		try {
			FileWriter out = new FileWriter(file, false);
			for (Student st : students) {
				out.write(String.format("%s,%s,%.2f,%.2f,%.2f\r\n", st.id, st.name, st.height, st.weight, st.bmi));
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> readFile(String fileName) {
		File file = new File("Stu.txt");
		BufferedReader reader = null;
		ArrayList<Student> v = new ArrayList<Student>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = reader.readLine()) != null) {
				String a[] = s.split(",");
				Student st = new Student(a[0], a[1], Double.parseDouble(a[2]), Double.parseDouble(a[3]));
				v.add(st);
			}
			reader.close();
			return v;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return v;
	}

	public void sortStudents(Comparator<Student> c) {
		Collections.sort(students, c);
	}

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

	public double Averofbmi(ArrayList<Student> students) {
		double sum = 0;
		double aver = 0;
		int i;
		for (i = 0; i < students.size(); i++) {
			sum = sum + students.get(i).bmi;
		}
		return aver = sum / (double) i;
	}

	public double Fchaofbmi(ArrayList<Student> students) {
		double fc;
		double fc1 = 0;
		for (int i = 0; i < students.size(); i++) {
			fc1 = fc1 + (students.get(i).bmi - Averofbmi(students)) * (students.get(i).bmi - Averofbmi(students));
		}
		fc = fc1 / students.size();
		return fc;
	}

	public void Mostofbmi(ArrayList<Student> students) {
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
	}

	public double Medianofbmi(ArrayList<Student> students) {
		double a[] = new double[students.size()];
		for (int i = 0; i < students.size(); i++) {
			a[i] = students.get(i).bmi;
		}
		Arrays.sort(a);
		if (students.size() % 2 == 0) {
			return a[(students.size() / 2)] + a[(students.size() / 2 - 1)];
		} else {
			return a[(students.size() - 1) / 2];
		}
	}

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

	public void inputStudent() {
		System.out.println("从键盘输入学生信息");
		Scanner in = new Scanner(System.in);
		System.out.println("輸入學生學號");
		String id = in.nextLine();
		if (isExists(id)) {
			System.out.println("學號輸入重複,請換一個學號輸入");
			id = in.nextLine();
		}
		System.out.println("輸入學生姓名");
		String name = in.nextLine();
		System.out.println("輸入學生身高(m)");
		double height = in.nextDouble();
		System.out.println("輸入學生體重(kg)");
		double weight = in.nextDouble();
		Student on1 = new Student(id, name, height, weight);
		students.add(on1);
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

	public void printStatics(ArrayList<Student> students) {
		for (Student i : students) {
			System.out.println(i.toString());
		}
		double aver = Averofbmi(students);
		System.out.print("bmi的平均值是： ");
		System.out.printf("%.2f", aver);
		double middle = Medianofbmi(students);
		System.out.println();
		System.out.print("bmi的中值是： ");
		System.out.printf("%.2f", middle);
		System.out.println("");
		Mostofbmi(students);
		double fc = Fchaofbmi(students);
		System.out.print("bmi的方差是： ");
		System.out.printf("%.2f", fc);

	}

	public static void main(String[] args) {
		ArrayList<Student> stu = new ArrayList<>();
		OOBMI x = new OOBMI();
		Scanner in = new Scanner(System.in);
		 x.genStudents(20);
//		int choice = 1;
//		for (; choice == 1;) {
//			x.inputStudent();
//			System.out.println("是否繼續輸入學生信息，是：1；不是：2");
//			choice = in.nextInt();
//		}
		 System.out.println("請輸入所要排序的放式：a--按身高排序；b--按體重排序；c--按bmi排序；d--按姓名排序；e--按學號排序；f--不排序");
		 String choice1 = in.next();
		 if (choice1.equals("a")) {
		 x.sortStudents(x.a);
		 }
		 if (choice1.equals("b")) {
		 x.sortStudents(x.b);
		 }
		 if (choice1.equals("c")) {
		 x.sortStudents(x.c);
		 }
		 if (choice1.equals("d")) {
		 x.sortStudents(x.d);
		 }
		 if (choice1.equals("e")) {
		 x.sortStudents(x.e);
		 }
		 if(choice1.equals("f")) {}
		x.printStatics(x.students);
		x.saveFile(x.students, "Stu.txt");
		int Index;
		System.out.println();
		Index = x.findStudent(x.students);
		System.out.println("是否修改或删除学生。是：1；不是：0");
		int choice2 = in.nextInt();
		if (choice2 == 0) {
		}
		if (choice2 == 1) {
			System.out.println("增加学生：1；修改学生信息：2；删除学生:3");
			int choice3 = in.nextInt();
			if (choice3 == 1) {
				x.inputStudent();
				x.saveFile(x.students, "Stu.txt");
			}
			if (choice3 == 2) {
				x.modifyStudent(x.students, Index);
				x.saveFile(x.students, "Stu.txt");
			}
			if (choice3 == 3) {
				x.deleteStudent(x.students, Index);
				x.saveFile(x.students, "Stu.txt");
			}
		}
		stu = x.readFile("");
	}

}