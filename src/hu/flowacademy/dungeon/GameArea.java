package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Options;
import hu.flowacademy.dungeon.quest.Quest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameArea {

  private static final int MAX_QUEST_COUNT = 4;
  public static final int STATIC_OBJECT_DAMAGE = 10;

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

      for (Player player : this.players) {
        if (player.isKilled()) {
          continue;
        }
        fightWithEnemy(player);
        // TODO badges persist
      }

    }
  }

  private void fightWithEnemy(Player player) {
    AbstractEnemy enemy = map.get(player.getPosition());

    System.out.println("Let's the game begin!");
    System.out.println("----------------------------------");
    System.out.printf("The player is: %s\n", player.getName());
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    System.out.printf("The enemy is: %s\n", enemy.getName());
    System.out.println("----------------------------------");
    System.out.println("Show me what you got!!!!!!");

    int rightAnswersCount = 0;

    for (Quest quest : enemy.getQuests()) {

      if (player.isKilled()) {
        break;
      }

      System.out.println(quest.getQuestion());
      System.out.println(
          quest.getOptions().stream()
              .map(Options::getOption)
              .sorted()
              .collect(Collectors.joining(" | ")));

      int index = scanInt();


      // TODO watch me
      Options option = quest.getOption(index);
      while (option == null) {
        index = scanInt();
        option = quest.getOption(index);
      }
      if (quest.getRightOption().equals(option)) {
        rightAnswersCount++;
        continue;
      } else if (enemy instanceof Enemy) {
        player.minusHp(((Enemy) enemy).getDamage());
      } else {
        // TODO if static object, ask this question again
        player.minusHp(STATIC_OBJECT_DAMAGE);
      }
    }

    if (rightAnswersCount == enemy.getQuests().size()) {
      System.out.println("All answers were right!");
      // TODO add badge to the enemy and gave it to player
    } else {
      System.out.println("Something went wrong...\nYou got nothing :P");
    }

    player.incrementPosition();

  }

  private int scanInt() {
    Scanner scanner = new Scanner(System.in);
    // FIXME try-catch if input is string
    // FIXME is input greater then options count
    return scanner.nextInt();
  }

  private boolean gameEnded() {
    return isPlayerStoredAllAchievements() ||
        isAllPlayersDead() ||
        isEndOfTheMap();
  }

  private boolean isEndOfTheMap() {
    for (Player p : players) {
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

    for (int i = 1; i <= palyersCount; i++) {
      System.out.println(i + " username is: ");
      String username = bufferedReader.readLine();
      players.add(new Player(username, false));
    }

    System.out.println("Users in the list:");

    players.stream()
        .map(Player::getName)
        .sorted()
        .forEach(System.out::println);

//    bufferedReader.close();

  }

}
