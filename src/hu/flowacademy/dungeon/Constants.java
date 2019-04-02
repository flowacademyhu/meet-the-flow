package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import hu.flowacademy.dungeon.quest.QuestFactory;
import hu.flowacademy.dungeon.quest.QuestLoader;
import java.util.ArrayList;
import java.util.List;

public final class Constants {

  private Constants() {}

//  public static List<Quest> quests = new ArrayList<>(){{
//    add(QuestFactory.create("Melyik a kakukktojas?", "SET", "GET", "PUT", "POST", "HEAD"));
//    add(QuestFactory.create("Mi Tasi kedvenc itala?", "Tequila", "Sör", "Viz", "Rum"));
//    add(QuestFactory.create("Kit utál Feri?", "Az embereket", "Mindent", "Semmit",  "Robit"));
//    add(QuestFactory.create("Kit vert meg Györgyi vasrúddal?", "Mentorokat", "Aki rászolgált", "A barátait",  "Hallgatókat"));
//    add(QuestFactory.create("Mi az élet értelme?", "42", "69", "káttű",  "Java"));
//    add(QuestFactory.create("Mi a kedvenc programozási nyelvünk?", "Java", "Javascript",  "PHP", "Brainfuck", "ArnoldC"));
//  }};

  public static List<Quest> quests = new ArrayList<>() {{
    addAll(QuestLoader.loadQuests());
  }};

}
