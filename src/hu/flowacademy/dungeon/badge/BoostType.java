package hu.flowacademy.dungeon.badge;

public enum BoostType {

  ZERO(0), TEN(10), TWENTY(20), THIRTY(30);

  private int value;

  BoostType(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }

}
