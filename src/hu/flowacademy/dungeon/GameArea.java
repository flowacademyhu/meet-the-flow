package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Options;
import hu.flowacademy.dungeon.quest.Quest;
import hu.flowacademy.dungeon.quest.QuestFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Function;

public class GameArea {

  private static final int MAX_QUEST_COUNT = 4;

  private List<Player> players = new ArrayList<>();

  private LinkedList<AbstractEnemy> map = new LinkedList<>();

  public static void main(String... args) {
    System.out.println("Game startred!");

    GameArea gameArea = new GameArea();

    gameArea.initDefault();

    try {
      gameArea.readPlayers();
    } catch (IOException | NumberFormatException e) {
      System.err.println("Invalid input when player reading!");
    }

    gameArea.mainLoop();

  }

  private void mainLoop() {
    while (true) {
      if (gameEnded()) {
        break;
      }

      for (Player player: this.players) {
        // TODO if player is dead continue
        // TODO get enemy on players position
        // TODO ask the quests
        // TODO if player can resolve all quests, the next player will come
        // TODO badges persist
        // TODO the player's postion++
      }

    }
  }

  private boolean gameEnded() {
    return isPlayerStoredAllAchievements() ||
        isAllPlayersDead() ||
        isEndOfTheMap();
  }

  private boolean isEndOfTheMap() {
    for (Player p: players) {
      if (p.getPosition() == map.size()) {
        return true;
      }
    }
    return false;
  }

  private boolean isAllPlayersDead() {
//    for (Player p: players) {
//      if (!p.isKilled()) {
//        return false;
//      }
//    }
//    return true;
    return players.stream().allMatch(Player::isKilled);
  }

  private boolean isPlayerStoredAllAchievements() {
//    for (Player p: players) {
//      if (p.hasAllAchievements()) {
//        return true;
//      }
//    }
//    return false;
    return players.stream()
        .anyMatch(Player::hasAllAchievements);
  }

  private void initDefault() {
    map.add(new StaticObject("Budi", getRandomQuests()));
    map.add(new Enemy("Tasi's dungeon", getRandomQuests(), 20));
    map.add(new StaticObject("Detox", getRandomQuests()));
    map.add(new StaticObject("Mr. Place", getRandomQuests()));
    map.add(new Enemy("Pub", getRandomQuests(), 30));
    map.add(new Enemy("Feri's hell", getRandomQuests(), 45));
    map.add(new Enemy("Robi's arena", getRandomQuests(), 35));
    map.add(new StaticObject("Behind the door", getRandomQuests()));
    map.add(new Enemy("Vasrudazó", getRandomQuests(), Integer.MAX_VALUE));
    map.add(new StaticObject("Bankett", getRandomQuests()));
  }

  private List<Quest> getRandomQuests() {
    List<Quest> responseList = new ArrayList<>();
    int questCount = new Random().nextInt(MAX_QUEST_COUNT);
    for (int i = 0; i < questCount; i++) {
      Quest quest = Constants.quests.get(
          new Random().nextInt(Constants.quests.size())
      );
      responseList.add(quest);
    }
    return responseList;
  }

  private void readPlayers() throws IOException {
    System.out.println("How many players will be play?");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line = bufferedReader.readLine();
    Integer palyersCount = Integer.valueOf(line);

    for (int i = 0; i < palyersCount; i++) {
      System.out.println(i + " username is: ");
      String username = bufferedReader.readLine();
      players.add(new Player(username, false));
    }

    System.out.println("Users in the list:");

    players.stream()
        .map(Player::getName)
        .sorted()
        .forEach(System.out::println);

  }

}
