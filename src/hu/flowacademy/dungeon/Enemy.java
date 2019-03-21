package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.util.List;

public class Enemy extends AbstractEnemy {

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
}
