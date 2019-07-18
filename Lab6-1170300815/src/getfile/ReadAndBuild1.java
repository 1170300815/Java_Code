package getfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import factory.LogFactory;
import ladder.Ladder;
import monkey.Monkey;
import monkey.MonkeyCrossRiverGui;
import relation.MLGraph;

public class ReadAndBuild1 {

  public static MLGraph graph1 =
      new MLGraph("src/Spring2019_HITCS_SC_Lab6-master/competition_22.txt");
  public static int time = 0;

  public static int n = graph1.getLadderNum(); // 梯子的总数量
  public static int h = graph1.getpedalNum(); // 每个梯子上的踏板数量
  public static int t = graph1.gettimeSpan(); // 产生猴子的时间间隔
  public static int N = graph1.getmonkeyNum(); // 产生猴子的总数量
  public static int k = graph1.getmonkeySpan(); // 每秒产生的猴子数
  public static int MV = graph1.getmostV(); // 猴子最大速度
  public static double ttrate = 0; // 系统的吞吐率
  public static double gprate = 0; // 系统的公平性

  public static String name = ReadAndBuild1.class.getName();
  public static Logger log1 = LogFactory.getLogger(1, name);

  public static void main(String[] args) {

    MonkeyCrossRiverGui ge = new MonkeyCrossRiverGui();

    try {
      // 将梯子加入到图graph中
      for (int i = 0; i < n; i++) {
        Ladder l = new Ladder(h, i);
        graph1.addLadder(l);
      }

      InputStreamReader reader = new InputStreamReader(
          new FileInputStream("src/Spring2019_HITCS_SC_Lab6-master/Competition_2.txt"));
      BufferedReader bfReader = new BufferedReader(reader);
      String lineString = new String();
      Pattern pattern1 =
          Pattern.compile("monkey=<[ ]*(\\d+)[ ]*,[ ]*(\\d+)[ ]*,[ ]*(\\S+)[ ]*,[ ]*(\\d+)[ ]*>");

      Matcher matcher;
      int linecount = 0;
      int count = 0;
      while (linecount < 500) {
        for (int j = 0; j < k; j++) {
          while ((lineString = bfReader.readLine()) != null) {
            linecount++;
            count++;
            if ((matcher = pattern1.matcher(lineString)).find()) {

              String group1 = matcher.group(1);
              String group2 = matcher.group(2);
              String group3 = matcher.group(3);
              String group4 = matcher.group(4);
              Monkey m =
                  new Monkey(Integer.parseInt(group2), group3, Integer.parseInt(group4), time);
              graph1.addmonkey(m);
              (new Thread(m)).start();
            }
          }
        }
        Thread.sleep(1000);
        time++;
        Thread.sleep(1000);
        time++;
        Thread.sleep(1000);
        time++;
        Thread.sleep(1000);
        time++;
        // Thread.sleep(1000);
        // time++;
      }

      while (true) { // 当猴子产生器 产生完猴子之后，时间会继续流逝，直到所有猴子都过到了对岸，此时的线程数量为3
        Thread.sleep(1000);
        if (Thread.activeCount() > 3) {
          time++;
        } else {
          if (ttrate != 0 && gprate != 0) {
            log1.info("吞吐率为：" + String.valueOf(ttrate));
            log1.info("公平性为：" + String.valueOf(gprate));
            Thread.yield();
            break;
          } else {
            continue;
          }
        }
      }
      bfReader.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

}
