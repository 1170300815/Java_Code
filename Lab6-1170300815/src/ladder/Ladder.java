package ladder;

import monkey.Monkey;

/**
 *
 * @author 范天祥
 *
 */
public class Ladder {

  // private final int n;
  private final int title;
  public Monkey[] pedal;
  public static Monkey no = new Monkey(Integer.MAX_VALUE, null, 0, 0);

  public Ladder(int n, int title) {
    // this.n = n;
    this.title = title;
    pedal = new Monkey[n];
    for (int i = 0; i < n; i++) {
      pedal[i] = no;
    }
  }

  public int getTitle() {
    return this.title;
  }
}
