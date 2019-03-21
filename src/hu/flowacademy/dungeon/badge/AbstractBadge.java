package hu.flowacademy.dungeon.badge;

public abstract class AbstractBadge {

  private int point;

  AbstractBadge(int point) {
    this.point = point;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }
}
