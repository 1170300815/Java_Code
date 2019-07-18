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
public class Strategy1 implements LadderStrategy {

  public static Ladder no = new Ladder(1, Integer.MAX_VALUE);

  @Override
  public Ladder Strategy(Monkey monkey, MLGraph graph) {
    List<Ladder> success1 = new ArrayList<>();
    List<Ladder> success2 = new ArrayList<>();
    int flag = 1;
    Set<Ladder> s = graph.ladders();
    synchronized (s) {
      for (Ladder l : s) {
        synchronized (l) {
          Monkey[] listpedal = l.pedal;
          for (int i = 0; i < listpedal.length; i++) {
            if (listpedal[i] != Ladder.no) {
              flag = 2;
              if (!listpedal[i].getDirection().equals(monkey.getDirection())) {
                flag = 0;
                break;
              }
            }
          }
          if (flag == 1) {
            success1.add(l);
          } else if (flag == 2) {
            success2.add(l);
          }
          flag = 1;
        }
      }
      if (!success1.isEmpty()) {
        int index = (int) (Math.random() * success1.size());
        if (success1.get(index).pedal[0] == Ladder.no) {
          success1.get(index).pedal[0] = monkey;
          return success1.get(index);
        }
      } else if (!success2.isEmpty()) {
        int index = (int) (Math.random() * success2.size());
        if (success2.get(index).pedal[0] == Ladder.no) {
          success2.get(index).pedal[0] = monkey;
          return success2.get(index);
        }
      }
    }
    return no;
  }
}
