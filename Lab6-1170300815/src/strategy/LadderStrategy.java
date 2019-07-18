package strategy;

import ladder.Ladder;
import monkey.Monkey;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public interface LadderStrategy {
  public abstract Ladder Strategy(Monkey monkey, MLGraph graph);

}
