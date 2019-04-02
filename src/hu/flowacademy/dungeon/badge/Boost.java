package hu.flowacademy.dungeon.badge;

public class Boost extends AbstractBadge {

  private int value;

  private BoostType type;

  public Boost(BoostType type) {
    super(BoostType.ZERO.getValue());
    this.type = type;
    this.value = type.getValue();
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BoostType getType() {
    return type;
  }

  public void setType(BoostType type) {
    this.type = type;
  }
}
