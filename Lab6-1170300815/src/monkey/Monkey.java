package monkey;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import getfile.ReadAndBuild1;
import ladder.Ladder;
import strategy.ContextLadderStrategy;
import strategy.Strategy1;
import strategy.Strategy2;
import strategy.Strategy3;

/**
 * 
 * @author 范天祥
 *
 */
public class Monkey implements Runnable {

  private final int monkeyID;
  private final String direction;
  private final int speed;
  protected final int bornTime;
  protected int reachTime;
  protected String State = "UnReach";
  protected int publicTime = ReadAndBuild1.time;

  public int getID() {
    return this.monkeyID;
  }

  public String getDirection() {
    return this.direction;
  }

  public int getTime() {
    return this.bornTime;
  }

  public Monkey(int monkeyID, String dircetion, int speed, int time) {
    this.monkeyID = monkeyID;
    this.direction = dircetion;
    this.speed = speed;
    this.bornTime = time;
  }

  @Override
  public void run() {
    Map<String, String> map1 = new HashMap<>();
    map1.put("L->R", "左");
    map1.put("R->L", "右");
    Map<String, String> map2 = new HashMap<>();
    map2.put("L->R", "左岸抵达右岸");
    map2.put("R->L", "右岸抵达左岸");

    Random rd1 = new Random();
    int index = rd1.nextInt(3);
    Ladder l = null;
    try {
      if (index == 0) {
        synchronized (Monkey.class) {
          l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
              new Strategy1());
        }
        while (l == Strategy1.no) {
          ReadAndBuild1.log1
              .info("第" + this.publicTime + "秒；" + this.monkeyID + "正在" + map1.get(this.direction)
                  + "岸等待；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
          Thread.sleep(1000);
          this.publicTime++;
          synchronized (Monkey.class) {
            l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
                new Strategy1());
          }
        }
        ReadAndBuild1.log1.info(
            "第" + this.publicTime + "秒；" + this.monkeyID + "正在第" + l.getTitle() + "架梯子的第0个踏板上，自"
                + this.direction + "前进；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
        Thread.sleep(1000);
      } else if (index == 1) {
        synchronized (Monkey.class) {
          l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
              new Strategy2());
        }
        while (l == Strategy2.no) {
          ReadAndBuild1.log1
              .info("第" + this.publicTime + "秒；" + this.monkeyID + "正在" + map1.get(this.direction)
                  + "岸等待；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
          Thread.sleep(1000);
          this.publicTime++;
          synchronized (Monkey.class) {
            l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
                new Strategy2());
          }
        }
        ReadAndBuild1.log1.info(
            "第" + this.publicTime + "秒；" + this.monkeyID + "正在第" + l.getTitle() + "架梯子的第0个踏板上，自"
                + this.direction + "前进；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
        Thread.sleep(1000);
      } else if (index == 2) {
        synchronized (Monkey.class) {
          l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
              new Strategy3());
        }
        while (l == Strategy3.no) {
          ReadAndBuild1.log1
              .info("第" + this.publicTime + "秒；" + this.monkeyID + "正在" + map1.get(this.direction)
                  + "岸等待；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
          Thread.sleep(1000);
          this.publicTime++;
          synchronized (Monkey.class) {
            l = new ContextLadderStrategy().ChoiceStrategy(this, ReadAndBuild1.graph1,
                new Strategy3());
          }
        }
        ReadAndBuild1.log1.info(
            "第" + this.publicTime + "秒；" + this.monkeyID + "正在第" + l.getTitle() + "架梯子的第0个踏板上，自"
                + this.direction + "前进；" + "已经出生" + (this.publicTime - this.bornTime) + "秒");
        Thread.sleep(1000);
      }

      int endtemp = 0;
      int temp = endtemp;
      while (true) {
        for (int i = endtemp + 1; i <= endtemp + this.speed && i <= ReadAndBuild1.h - 1; i++) {
          if (l.pedal[i] == Ladder.no) {
            temp = i;
          } else {
            break;
          }
        }
        if (temp == endtemp) {
          this.publicTime++;
          ReadAndBuild1.log1.info("第" + this.publicTime + "秒；" + this.monkeyID + "正在第" + l.getTitle()
              + "架梯子的第" + temp + "个踏板上，自" + this.direction + "前进；" + "已经出生"
              + (this.publicTime - this.bornTime) + "秒");
          Thread.sleep(1000);
        } else {
          synchronized (l) {
            l.pedal[temp] = this;
            l.pedal[endtemp] = Ladder.no;
            endtemp = temp;
          }
          this.publicTime++;
          ReadAndBuild1.log1.info("第" + this.publicTime + "秒；" + this.monkeyID + "正在第" + l.getTitle()
              + "架梯子的第" + temp + "个踏板上，自" + this.direction + "前进；" + "已经出生"
              + (this.publicTime - this.bornTime) + "秒");
          Thread.sleep(1000);

          if (l.pedal[ReadAndBuild1.h - 1].equals(this)) {
            l.pedal[ReadAndBuild1.h - 1] = Ladder.no;
            this.publicTime++;
            this.reachTime = this.publicTime;
            this.State = "Reach";
            ReadAndBuild1.log1.info("第" + this.publicTime + "秒；" + this.monkeyID + "以从"
                + map2.get(this.direction) + "，共耗时" + (this.publicTime - this.bornTime) + "秒");
            break;
          }
        }
        temp = endtemp;
      }
      Thread.yield();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  @Override
  public boolean equals(Object b) {
    if (b instanceof Monkey) {
      Monkey other = (Monkey) b;
      if (this.monkeyID == other.monkeyID) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return String.valueOf(monkeyID).hashCode();
  }
}
