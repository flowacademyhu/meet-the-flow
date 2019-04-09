package hu.flowacademy.dungeon.badge;

import hu.flowacademy.dungeon.persistence.Saveable;
import java.io.Serializable;
import java.util.Map;

public class Boost extends AbstractBadge implements Saveable {

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

  @Override
  public Map<String, ? extends Serializable> getSaveables() {
    return Map.of("value", this.value, "type", this.type, "point", this.getPoint());
  }

  @Override
  public boolean equals(Saveable saveable) {
    return equals(saveable);
  }
}
