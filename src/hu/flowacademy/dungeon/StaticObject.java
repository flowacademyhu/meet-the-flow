package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.util.List;

public class StaticObject extends AbstractEnemy {

  public StaticObject(String name, List<Quest> quests) {
    super(name, quests);
  }

  @Override
  public int compareTo(AbstractEnemy o) {
    return super.compareTo(o);
  }
}
