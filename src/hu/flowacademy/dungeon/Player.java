package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.badge.AbstractBadge;
import hu.flowacademy.dungeon.badge.Achievement;
import java.util.ArrayList;
import java.util.List;

public class Player {

  private static final int MAX_ACHIEVEMENTS = 4;
  private static final int DEFAULT_HEALTH = 100;

  private String name;

  private int health;

  private int position;

  private boolean killed;

  public boolean isKilled() {
    return killed;
  }

  public void setKilled(boolean killed) {
    this.killed = killed;
  }

  private List<AbstractBadge> badges = new ArrayList<>();

  private Player(String name, int health) {
    this.name = name;
    this.health = health;
  }

  public boolean hasAllAchievements() {
    int counter = 0;
    for (AbstractBadge badge : this.badges) {
      if (badge instanceof Achievement) {
        counter++;
      }
    }
    return counter == MAX_ACHIEVEMENTS;
  }

  public Player(String name, boolean killed) {
    this(name, DEFAULT_HEALTH);
    this.killed = killed;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public List<AbstractBadge> getBadges() {
    return badges;
  }

  public void setBadges(List<AbstractBadge> badges) {
    this.badges = badges;
  }
}
