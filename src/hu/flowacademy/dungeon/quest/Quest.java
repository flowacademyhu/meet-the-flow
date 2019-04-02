package hu.flowacademy.dungeon.quest;

import java.util.List;

public class Quest {

  private String question;

  private Options rightOption;

  private List<Options> options;

  // TODO private int level; // for quest level


  public Quest() {
  }

  public Quest(String question, Options rightOption,
      List<Options> options) {
    this.question = question;
    this.rightOption = rightOption;
    this.options = options;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Options getRightOption() {
    return rightOption;
  }

  public void setRightOption(Options rightOption) {
    this.rightOption = rightOption;
  }

  public List<Options> getOptions() {
    return options;
  }

  public void setOptions(List<Options> options) {
    this.options = options;
  }

  public Options getOption(int index) {
    try {
      return this.options.get(index - 1);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Input was not a number!");
      return null;
    }

  }
}
