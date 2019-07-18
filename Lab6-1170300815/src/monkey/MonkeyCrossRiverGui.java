package monkey;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import getfile.ReadAndBuild1;
import ladder.Ladder;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public class MonkeyCrossRiverGui extends JFrame {

  static final int WIDTH = 800;
  static final int HEIGHT = 600;

  public MonkeyCrossRiverGui() {
    this.Show();
    this.setSize(WIDTH, HEIGHT);
    this.setTitle("猴子过河");
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void Show() {
    GuiPanel panel = new GuiPanel();
    Thread t = new Thread(panel);
    t.start();
    this.add(panel);
  }
}


class GuiPanel extends JPanel implements Runnable {

  MLGraph graph = ReadAndBuild1.graph1;

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawString("参数设置为：", 10, 50);
    g.drawString("n: " + String.valueOf(ReadAndBuild1.n), 100, 50);
    g.drawString("h: " + String.valueOf(ReadAndBuild1.h), 150, 50);
    g.drawString("t: " + String.valueOf(ReadAndBuild1.t), 200, 50);
    g.drawString("N: " + String.valueOf(ReadAndBuild1.N), 250, 50);
    g.drawString("k: " + String.valueOf(ReadAndBuild1.k), 300, 50);
    g.drawString("MV: " + String.valueOf(ReadAndBuild1.MV), 350, 50);
    g.drawString("running time: " + String.valueOf(ReadAndBuild1.time) + "s", 400, 50);
    g.drawString("吞吐率: ", 520, 50);
    if (Thread.activeCount() == 3) {
      ReadAndBuild1.ttrate = (double) ReadAndBuild1.N / (double) (ReadAndBuild1.time);
      g.drawString(String.valueOf((double) ReadAndBuild1.N / (double) (ReadAndBuild1.time)), 570,
          50);
    }
    g.drawString("公平性: ", 520, 70);
    double sum1 = 0;
    double sum2 = (ReadAndBuild1.N * (ReadAndBuild1.N - 1));
    for (Monkey m1 : graph.monkeys()) {
      for (Monkey m2 : graph.monkeys()) {
        if (!m1.equals(m2)) {
          // if ((m1.bornTime - m2.bornTime) * (m1.reachTime - m2.reachTime) >= 0) {
          if ((m1.bornTime - m2.bornTime)
              * (m1.bornTime + m1.reachTime - m2.bornTime - m2.reachTime) >= 0) {
            sum1 += 1;
          } else {
            sum1 -= 1;
          }
          // System.out.print(sum1 + "\n");
        }
      }
    }
    if (Thread.activeCount() == 3) {
      ReadAndBuild1.gprate = 1.0 * (sum1 / sum2);
      g.drawString(String.valueOf(1.0 * (sum1 / sum2)), 570, 70);
    }

    // 画梯子
    int yPerLadder = 100;
    int xPerPedal = 30;
    for (int i = 1; i <= ReadAndBuild1.n; i++) {
      g.drawLine(80, (yPerLadder * i - 25), 80 + 30 * ReadAndBuild1.h, (yPerLadder * i - 25));
      g.drawLine(80, (yPerLadder * i + 25), 80 + 30 * ReadAndBuild1.h, (yPerLadder * i + 25));

      for (int k = 0; k <= ReadAndBuild1.h; k++) {
        g.drawLine(80 + xPerPedal * k, (yPerLadder * i - 25), 80 + xPerPedal * k,
            (yPerLadder * i + 25));
      }
    }
    // 模拟猴子的移动
    for (Ladder l : graph.ladders()) {
      for (int i = 0; i < l.pedal.length; i++) {
        if (l.pedal[i].getID() != Integer.MAX_VALUE) {
          if ((l.pedal[i].getDirection().equals("L->R"))) {
            // 模拟向右行进的猴子
            String text = "Left";

            BufferedImage img1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img1.createGraphics();
            Font font = new Font("Arial", Font.PLAIN, 48);
            g2d.setFont(font);
            FontMetrics fm = g2d.getFontMetrics();
            int width = fm.stringWidth(text);
            int height = fm.getHeight();
            g2d.dispose();

            img1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = img1.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);
            g2d.setFont(font);
            fm = g2d.getFontMetrics();
            g2d.setColor(Color.RED);
            g2d.drawString(text, 0, fm.getAscent());
            g2d.dispose();

            g.drawImage(img1, 80 + i * xPerPedal, yPerLadder * (l.getTitle() + 1) - 25, 30, 60,
                this);
            g.drawString(String.valueOf(l.pedal[i].getID()), 85 + i * xPerPedal,
                yPerLadder * (l.getTitle() + 1) - 30);
          } else {
            // 模拟向左行进的猴子
            String text = "Right";

            BufferedImage img2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img2.createGraphics();
            Font font = new Font("Arial", Font.PLAIN, 48);
            g2d.setFont(font);
            FontMetrics fm = g2d.getFontMetrics();
            int width = fm.stringWidth(text);
            int height = fm.getHeight();
            g2d.dispose();

            img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = img2.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);
            g2d.setFont(font);
            fm = g2d.getFontMetrics();
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, 0, fm.getAscent());
            g2d.dispose();
            g.drawImage(img2, 80 + 30 * ReadAndBuild1.h - xPerPedal * i - 30,
                yPerLadder * (l.getTitle() + 1) - 25, 30, 60, this);
            g.drawString(String.valueOf(l.pedal[i].getID()),
                80 + 30 * ReadAndBuild1.h - xPerPedal * i - 20,
                yPerLadder * (l.getTitle() + 1) - 30);
          }
        }
      }
    }
    g.drawString("左岸:", 10, 110);
    g.drawString("右岸:", 130 + 30 * ReadAndBuild1.h - 25, 110);
    int x = 0;
    int y = 0;
    for (Monkey m : graph.monkeys()) {
      if (m.State.equals("Reach")) {
        if (m.getDirection().equals("R->L")) {
          g.drawString(String.valueOf(m.getID()), 15, y + 140);
          y += 20;
        } else {
          g.drawString(String.valueOf(m.getID()), 135 + 30 * ReadAndBuild1.h - 25, x + 140);
          x += 20;
        }
      }
    }
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (Thread.activeCount() == 2) {
        Thread.yield();
      }
      repaint();
    }
  }
}
