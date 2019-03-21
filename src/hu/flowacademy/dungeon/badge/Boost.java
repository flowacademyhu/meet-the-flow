package hu.flowacademy.dungeon.badge;

public class Boost extends AbstractBadge {

  private int value;

  public Boost(int value) {
    super(0);
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
