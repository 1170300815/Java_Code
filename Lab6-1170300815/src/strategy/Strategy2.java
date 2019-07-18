package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import ladder.Ladder;
import monkey.Monkey;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public class Strategy2 implements LadderStrategy {

  public static Ladder no = new Ladder(1, Integer.MAX_VALUE);

  @Override
  public Ladder Strategy(Monkey monkey, MLGraph graph) {
    Map<Ladder, Integer> map = new HashMap<>();
    synchronized (graph.ladders()) {
      for (Ladder l : graph.ladders()) {
        int num = 0;
        synchronized (l) {
          map.put(l, num);
          Monkey[] listpedal = l.pedal;
          for (int i = 0; i < listpedal.length; i++) {
            if (listpedal[i] != Ladder.no) {
              if (!listpedal[i].getDirection().equals(monkey.getDirection())) {
                map.remove(l);
                break;
              }
            }
            if (listpedal[i] != Ladder.no) {
              num++;
              map.put(l, num);
            }
          }
        }
      }

      Comparator<Map.Entry<Ladder, Integer>> valueComparator =
          new Comparator<Map.Entry<Ladder, Integer>>() {
            @Override
            public int compare(Entry<Ladder, Integer> o1, Entry<Ladder, Integer> o2) {
              return o1.getValue() - o2.getValue();
            }
          };

      List<Map.Entry<Ladder, Integer>> list =
          new ArrayList<Map.Entry<Ladder, Integer>>(map.entrySet());

      Collections.sort(list, valueComparator);
      for (Map.Entry<Ladder, Integer> entry : list) {
        if (entry.getKey().pedal[0] == Ladder.no) {
          entry.getKey().pedal[0] = monkey;
          return entry.getKey();
        }
      }
      return no;
    }
  }
}
