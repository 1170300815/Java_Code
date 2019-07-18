package monkey;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import factory.LogFactory;
import ladder.Ladder;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public class MonkeyGenerator {

  static MLGraph graph = new MLGraph("src/settings/data.txt");
  static int time = 0;

  public static int n = graph.getLadderNum();
  public static int h = graph.getpedalNum();
  public static int t = graph.gettimeSpan();
  public static int N = graph.getmonkeyNum();
  public static int k = graph.getmonkeySpan();
  public static int MV = graph.getmostV();
  public static double ttrate = 0;
  public static double gprate = 0;

  static String name = MonkeyGenerator.class.getName();
  static Logger log1 = LogFactory.getLogger(1, name);

  public static void main(String[] args) {
    MonkeyCrossRiverGui ge = new MonkeyCrossRiverGui();
    try {

      for (int i = 0; i < n; i++) {
        Ladder l = new Ladder(h, i);
        graph.addLadder(l);
      }

      Map<Integer, String> map = new HashMap<>();
      map.put(0, "L->R");
      map.put(1, "R->L");
      int remainder = N % k;
      for (int i = 0; i <= ((N / k) - 1) * t; i++) {
        if (i % t != 0 && i != 0) {
          Thread.sleep(1000);
          time++;
        } else {
          for (int j = 0; j < k; j++) {
            Random rd1 = new Random();
            int index1 = rd1.nextInt(2);
            int index2 = rd1.nextInt(MV - 1) + 1;

            Monkey m = new Monkey((i / t) * 10 + j, map.get(index1), index2, time);
            graph.addmonkey(m);
            (new Thread(m)).start();
          }
          Thread.sleep(1000);
          time++;
        }
      }
      if (remainder != 0) {
        for (int i = 0; i < remainder; i++) {
          Random rd1 = new Random();
          int index1 = rd1.nextInt(2);
          int index2 = rd1.nextInt(MV - 1) + 1;
          Monkey m = new Monkey((N / k) * 10 + i, map.get(index1), index2, time);
          (new Thread(m)).start();
        }
        Thread.sleep(1000);
        time++;
      }
      while (true) {
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
    } catch (InterruptedException e) {
    }
  }
}
