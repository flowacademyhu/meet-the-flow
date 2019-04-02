package hu.flowacademy.dungeon.badge;

public class Achievement extends AbstractBadge{

  private String name;

  private AchievementType type;

  public Achievement(String name, int point) {
    super(point);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
