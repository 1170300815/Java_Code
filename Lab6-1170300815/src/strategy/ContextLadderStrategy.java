package strategy;

import ladder.Ladder;
import monkey.Monkey;
import relation.MLGraph;

/**
 * 
 * @author 范天祥
 *
 */
public class ContextLadderStrategy {

  public Ladder ChoiceStrategy(Monkey monkey, MLGraph graph, LadderStrategy choice) {
    return choice.Strategy(monkey, graph);
  }
}
