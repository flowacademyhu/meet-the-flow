package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.util.List;

public abstract class AbstractEnemy implements Comparable<AbstractEnemy> {

  private String name;

  private List<Quest> quests;

  // TODO private int level; // for quest level

  AbstractEnemy(String name, List<Quest> quests) {
    this.name = name;
    this.quests = quests;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Quest> getQuests() {
    return quests;
  }

  public void setQuests(List<Quest> quests) {
    this.quests = quests;
  }

  @Override
  public int compareTo(AbstractEnemy o) {
    if (this.equals(o) || o.name.charAt(0) == this.name.charAt(0)) {
      return 0;
    } else {
      if (o.name.charAt(0) > this.name.charAt(0)) {
        return -1;
      } else {
        return 1;
      }
    }
//    return this.equals(o) ? 0 : o.name.charAt(0) > this.name.charAt(0) ? -1 : 1;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
