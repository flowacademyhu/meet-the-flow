package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Function;

public class GameArea {

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

      // getActualPlayer
      // getEnemyFromActualPosition
      //

    }
  }

  private boolean gameEnded() {
    // TODO check players has all achievements
    // TODO check players are the end of the enemies
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
    return List.of();
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

  private static void scanFromConsole() {
    Scanner scanner = new Scanner(System.in);

    var username = scanner.nextLine();

    System.out.println("Your name is " + username + "! THanks!");

    System.out.println("Tell me your age!");

    int age = scanner.nextInt();

    System.out.println(age < 12 ? "Play with your toys!" : "Too old!");
  }

  private static void readFromConsole() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String line;
    int i = 0;

    while ((line = bufferedReader.readLine()) != null) {
      if ("q".equalsIgnoreCase(line)) {
        System.exit(0);
      }
      System.out.println(i++ + " line >> " + line);
    }
  }

}
