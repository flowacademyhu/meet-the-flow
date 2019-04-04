package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.persistence.Saveable;
import hu.flowacademy.dungeon.quest.Quest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Enemy extends AbstractEnemy implements Saveable {

  private int damage;

  public Enemy(String name, List<Quest> quests, int damage) {
    super(name, quests);
    this.damage = damage;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  @Override
  public int compareTo(AbstractEnemy o) {
    return super.compareTo(o);
  }

  @Override
  public Map<String, ? extends Serializable> getSaveables() {
    return Map.of("damage", this.damage, "name", this.getName());
  }
}
