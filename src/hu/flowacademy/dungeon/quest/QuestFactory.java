package hu.flowacademy.dungeon.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class QuestFactory {

  public static Quest create(String question, String answer, String... otherOptions) {
    Options rightOption = new Options(answer);

    List<Options> optionList = new ArrayList<>();
    optionList.add(rightOption);

    if (otherOptions != null) {
      optionList.addAll(
          Stream.of(otherOptions)
              .map(Options::new)
              .collect(Collectors.toList())
      );
    }

    optionList.sort((item1, item2) -> item1.getOption().compareToIgnoreCase(item2.getOption()));
    return new Quest(question, rightOption, optionList);
  }

}
