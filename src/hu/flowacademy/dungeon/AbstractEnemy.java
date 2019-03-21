package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.util.List;

public abstract class AbstractEnemy {

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
}
