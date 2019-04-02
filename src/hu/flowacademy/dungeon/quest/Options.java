package hu.flowacademy.dungeon.quest;

import java.util.Objects;

public class Options {

  private String option;

  public Options(String option) {
    this.option = option;
  }

  public String getOption() {
    return option;
  }

  public void setOption(String option) {
    this.option = option;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Options options = (Options) o;
    return Objects.equals(option, options.option);
  }

  @Override
  public int hashCode() {
    return Objects.hash(option);
  }
}
