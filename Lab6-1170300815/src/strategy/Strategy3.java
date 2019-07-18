package strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import ladder.Ladder;
import monkey.Monkey;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public class Strategy3 implements LadderStrategy {

  public static Ladder no = new Ladder(1, Integer.MAX_VALUE);

  @Override
  public Ladder Strategy(Monkey monkey, MLGraph graph) {
    List<Ladder> success = new ArrayList<>();
    int flag = 0;
    Set<Ladder> s = graph.ladders();
    synchronized (s) {
      for (Ladder l : s) {
        synchronized (l) {
          Monkey[] listpedal = l.pedal;
          for (int i = 0; i < listpedal.length; i++) {
            if (listpedal[i] != Ladder.no) {
              flag = 1;
              break;
            }
          }
          if (flag == 1) {
            flag = 0;
            continue;
          } else {
            success.add(l);
          }
        }
      }
      if (!success.isEmpty()) {
        int index = (int) (Math.random() * success.size());
        if (success.get(index).pedal[0] == Ladder.no) {
          success.get(index).pedal[0] = monkey;
          return success.get(index);
        } else {
          return no;
        }
      } else {
        return no;
      }
    }
  }
}
