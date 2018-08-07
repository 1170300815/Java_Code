package edu.hit1160300610.experiment6;

import javax.swing.*;

import java.util.concurrent.*; 
import java.awt.*;
import java.awt.event.*;

public class LLK implements ActionListener {
	JPanel Panel1;
	JPanel Panel2;
	JPanel Panel3;
	JFrame mainFrame; 
	Container thisContainer;
	
	JButton GButton[][] = new JButton[6][5];
	JButton exit, reset, renew; 
	JLabel jlblTime = new JLabel("Time remains：");
	JLabel time = new JLabel();
	JLabel jlblScore = new JLabel("Score:");
	JLabel ScoreL = new JLabel("0"); 
	JButton Button1, Button2; 
	int SGButton[][] = new int[8][7];
	static boolean IftakeButton = false; 
	int x0 = 0, y0 = 0;
	int x = 0, y = 0;
	int Step1 = 0, Step2 = 0;
	int LOGButton; 
	int i, j, k, n;

	public void JFrm() {
		ImageIcon pic[]=new ImageIcon[26];
		pic[0]=null;
		for(int i=1;i<=25;i++) {
			pic[i]=new ImageIcon("timg("+(i-1)+").jpg");
		}
		
		mainFrame = new JFrame("llk");
		thisContainer = mainFrame.getContentPane();
		thisContainer.setLayout(new BorderLayout());
		Panel1 = new JPanel();
		Panel2 = new JPanel();
		Panel3 = new JPanel();
		thisContainer.add(Panel1, "Center");
		thisContainer.add(Panel2, "South");
		thisContainer.add(Panel3, "North");
		Panel1.setLayout(new GridLayout(6, 5));
		for (int Hang = 0; Hang < 6; Hang++) {
			for (int Lie = 0; Lie < 5; Lie++) {
				GButton[Hang][Lie] = new JButton(pic[SGButton[Hang+1][Lie+1]]);
				GButton[Hang][Lie].addActionListener(this);
				Panel1.add(GButton[Hang][Lie]);
			}
		}
		exit = new JButton("Exit");
		exit.addActionListener(this);
		reset = new JButton("Reset");
		reset.addActionListener(this);
		renew = new JButton("Again");
		renew.addActionListener(this);
		Panel2.add(exit);
		Panel2.add(reset);
		Panel2.add(renew);
		ScoreL.setText(String.valueOf(Integer.parseInt(ScoreL.getText())));
		Panel3.setLayout(new GridLayout(1,4,5,5));
		Panel3.add(jlblTime);
		Panel3.add(time);
		Panel3.add(jlblScore);
		Panel3.add(ScoreL);
		mainFrame.setBounds(280, 100, 500, 450);
		mainFrame.setVisible(true);
	}

	public void randomBuild() {
		int Suiji, Hang, Lie;
		for (int ii = 1; ii < 16; ii++) {
			Suiji = (int) (1 + Math.random() * 25);
			for (int a = 1; a < 3; a++) {
				Lie = (int) (1 + Math.random() * 5);
				Hang = (int) (1 + Math.random() * 6);
				
				for (; SGButton[Hang][Lie] != 0;) {

					Lie = (int) (1 + Math.random() * 5);
					Hang = (int) (1 + Math.random() * 6);
				}
				this.SGButton[Hang][Lie] = Suiji;
			}
		}
	}

	
 
	  
	public class 倒计时 {  
	    private volatile int limitSec ;  
	    private int curSec;   
	    public 倒计时(int limitSec) throws InterruptedException{  
	        this.limitSec = limitSec;  
	        this.curSec = limitSec;     
	        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);  
	        exec.scheduleAtFixedRate(new Task(),0,1,TimeUnit.SECONDS);  
	        TimeUnit.SECONDS.sleep(limitSec);    
	        exec.shutdownNow();  
	        time.setText("Time out！");  
	    }  
	    private class Task implements Runnable{  
	        public void run(){  
	            time.setText(--curSec +" s");  
	        }  
	    }   

	  
	} 
	public void Score(int Choice) {
		if (Choice == 1) {
			ScoreL.setText(String.valueOf(Integer.parseInt(ScoreL.getText()) + 10));
		}
		if (Choice == 0) {
			ScoreL.setText("0");
		}
	}

	public void Renew() {
		int Restore[] = new int[30];
		int n = 0;
		int Hang;
		int Lie;
		int SGButton[][] = new int[8][7];
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k < 6; k++) {
				if (this.SGButton[j][k] != 0) {
					Restore[n] = this.SGButton[j][k];
					n++;
				}
			}
		}
		n--;
		this.SGButton = SGButton;
		while (n >= 0) {
			Lie = (int) (1 + Math.random() * 5);
			Hang = (int) (1 + Math.random() * 6);
			for (; SGButton[Hang][Lie] != 0;) {
				Lie = (int) (1 + Math.random() * 5);
				Hang = (int) (1 + Math.random() * 6);
			}
			this.SGButton[Hang][Lie] = Restore[n];
			n--;
		}
		mainFrame.setVisible(false);
		IftakeButton = false; 
		JFrm();
		for (int j = 0; j <= 5; j++) {
			for (int j1 = 0; j1 <= 4; j1++) {
				if (SGButton[j + 1][j1 + 1] == 0)
					GButton[j][j1].setVisible(false);
			}
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == renew) {
			int SGButton[][] = new int[8][7];
			this.SGButton = SGButton;
			randomBuild();
			mainFrame.setVisible(false);
			IftakeButton = false;
			JFrm();
			Score(0);
		}
		if (e.getSource() == exit)
			System.exit(0);
		if (e.getSource() == reset)
			Renew();
		for (int Hang = 0; Hang < 6; Hang++) {
			for (int Lie = 0; Lie < 5; Lie++) {
				if (e.getSource() == GButton[Hang][Lie])
					estimateEven(Hang + 1, Lie + 1, GButton[Hang][Lie]);
			}
		}
	}

	public void estimateEven(int X, int Y, JButton bu) {
		if (!IftakeButton == true) {
			x = X;
			y = Y;
			Step2 = SGButton[x][y];
			Button2 = bu;
			IftakeButton = true;
		} else {
			x0 = x;
			y0 = y;
			Step1 = Step2;
			Button1 = Button2;
			x = X;
			y = Y;
			Step2 = SGButton[x][y];
			Button2 = bu;
			if (Step1 == Step2 && Button2 != Button1)
				Remv();

		}
	}
	
	public void remove() {
		Button1.setVisible(false);
		Button2.setVisible(false);
		Score(1);
		IftakeButton = false;
		k = 0;
		SGButton[x0][y0] = 0;
		SGButton[x][y] = 0;
	}

	public void Remv() {
		if ((x0 == x && (y0 == y + 1 || y0 == y - 1)) || ((x0 == x + 1 || x0 == x - 1) && (y0 == y))) { 
			remove();
		} else {
			for (j = 0; j < 7; j++) {
				if (SGButton[x0][j] == 0) {
					if (y == j)
						Lpass1();
					
					for (i = y + 1; y < j && i <= j; i++) { 
						if (SGButton[x][i] != 0) {
							k = 0;
							break;
						} else
							k = 1;
					}
					if (k == 1)
						Lpass1();

					for (i = y - 1; j < y && i >= j; i--) { 
						if (SGButton[x][i] != 0) {
							k = 0;
							break;
						} else
							k = 1;
						
					}
					if (k == 1)
						Lpass1();
				}
				if (k == 2) {
					if (x0 == x)
						remove();
					for (n = x0; x0 < x && n <= x - 1; n++) {
						if (SGButton[n][j] != 0) {
							k = 0;
							break;
						}
						if (SGButton[n][j] == 0 && n == x - 1)
							remove();
					}
					for (n = x0; x0 > x && n >= x + 1; n--) {
						if (SGButton[n][j] != 0) {
							k = 0;
							break;
						}
						if (SGButton[n][j] == 0 && n == x + 1)
							remove();
					}
				}
			}
			for (i = 0; i < 8; i++) { 
				if (SGButton[i][y0] == 0) {
					for (j = x - 1; x > i && j >= i; j--) {
						if (SGButton[j][y] != 0) {
							k = 0;
							break;
						} else
							k = 1;
					}
					if (k == 1)
						Rpass1();

					for (j = x + 1; x < i && j <= i; j++) {
						if (SGButton[j][y] != 0) {
							k = 0;
							break;
						} else
							k = 1;
					}
					if (k == 1)
						Rpass1();

					if (x == i)
						Rpass1();
				}
				if (k == 2) {
					if (y0 == y) 
						remove();
					for (n = y0; y0 < y && n <= y - 1; n++) {
						if (SGButton[i][n] != 0) {
							k = 0;
							break;
						}
						if (SGButton[i][n] == 0 && n == y - 1)
							remove();
					}

					for (n = y0; y0 > y && n >= y + 1; n--) {
						if (SGButton[i][n] != 0) {
							k = 0;
							break;
						}
						if (SGButton[i][n] == 0 && n == y + 1)
							remove();
					}
				}
			}
		}
	}

	public void Lpass1() { 
		for (i = y0 - 1; y0 > j && i >= j; i--) { 
			if (SGButton[x0][i] != 0) {
				k = 0;
				break;
			} else
				k = 2;
			
		}

		
		for (i = y0 + 1; y0 < j && i <= j; i++) {
			if (SGButton[x0][i] != 0) {
				k = 0;
				break;
			} else
				k = 2;
		}

	}

	public void Rpass1() {

		for (j = x0 - 1; x0 > i && j >= i; j--) {
			if (SGButton[j][y0] != 0) {
				k = 0;
				break;
			} else
				k = 2;
		}

		for (j = x0 + 1; x0 < i && j <= i; j++) {
			if (SGButton[j][y0] != 0) {
				k = 0;
				break;
			} else
				k = 2;
		}

	}

	
  
	
	
	

	public static void main(String[] args) throws InterruptedException {
		LLK llk = new LLK();
	
		llk.randomBuild();
		llk.JFrm();
		llk.new 倒计时(90);

	}

}
