package relation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import ladder.Ladder;
import monkey.Monkey;

/**
 * 
 * @author 范天祥
 *
 */
public class MLGraph {

  private int ladderNum;
  private int pedalNum;
  private int timeSpan;
  private int monkeyNum;
  private int monkeySpan;
  private int mostV;

  private final Set<Monkey> monkeys = new HashSet<>();
  private final Set<Ladder> ladders = new HashSet<>();

  public Set<Monkey> monkeys() {
    Set<Monkey> monkeys = Collections.synchronizedSet(new HashSet<>());
    monkeys.addAll(this.monkeys);
    return monkeys;
  }

  public Set<Ladder> ladders() {
    Set<Ladder> ladders = Collections.synchronizedSet(new HashSet<>());
    ladders.addAll(this.ladders);
    return ladders;
  }

  public int getLadderNum() {
    return this.ladderNum;
  }

  public int getpedalNum() {
    return this.pedalNum;
  }

  public int gettimeSpan() {
    return this.timeSpan;
  }

  public int getmonkeyNum() {
    return this.monkeyNum;
  }

  public int getmonkeySpan() {
    return this.monkeySpan;
  }

  public int getmostV() {
    return this.mostV;
  }

  public boolean addLadder(Ladder l) {
    if (this.ladders.contains(l)) {
      return false;
    } else {
      this.ladders.add(l);
      return true;
    }
  }

  public boolean addmonkey(Monkey m) {
    if (this.monkeys.contains(m)) {
      return false;
    } else {
      this.monkeys.add(m);
      return true;
    }
  }

  public MLGraph(String filePath) {
    File file = new File(filePath);
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNext()) {
        String s[] = sc.nextLine().split(" ");
        if (s[0].equals("ladderNum")) {
          this.ladderNum = Integer.valueOf(s[1]);
        } else if (s[0].equals("pedalNum")) {
          this.pedalNum = Integer.valueOf(s[1]);
        } else if (s[0].equals("timeSpan")) {
          this.timeSpan = Integer.valueOf(s[1]);
        } else if (s[0].equals("monkeyNum")) {
          this.monkeyNum = Integer.valueOf(s[1]);
        } else if (s[0].equals("monkeySpan")) {
          this.monkeySpan = Integer.valueOf(s[1]);
        } else if (s[0].equals("mostV")) {
          this.mostV = Integer.valueOf(s[1]);
        }
      }
      sc.close();
    } catch (FileNotFoundException e) {
    }
  }
}
