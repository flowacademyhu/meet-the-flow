package hu.flowacademy.dungeon.quest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestLoader {

  private static final String DEFAULT_FILE_NAME = "/tmp/quests.txt";
  private static final String ANSWER_SEPARATOR = "\\|";

  public static List<Quest> loadQuests() {
    return loadQuests(DEFAULT_FILE_NAME);
  }

  public static List<Quest> loadQuests(String filepath) {
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(filepath)))) {
      List<Quest> list = new ArrayList<>();
      String line = "";
      while ((line = bufferedReader.readLine()) != null) {
        Quest quest = null;
        if (line.startsWith("Q:")) {
          quest = new Quest();
          quest.setQuestion(line);
        } else if (line.startsWith("A:")) {
          quest.setOptions(splitAnswers(line.substring(2)));
        } else if (line.startsWith("R:")) {
          quest.setRightOption(new Options(line.substring(2)));
          list.add(quest);
        } else {
          System.err.printf("Invalid file format: %s\n", line);
        }
      }
      return list;
    } catch (IOException e) {
      System.err.printf("File not found: %s\n", filepath);
      return null;
    }
  }

  private static List<Options> splitAnswers(String line) {
    return Stream.of(line.split(ANSWER_SEPARATOR))
        .map(Options::new).collect(Collectors.toList());
  }

}
