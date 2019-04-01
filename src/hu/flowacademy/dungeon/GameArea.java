package hu.flowacademy.dungeon;

import hu.flowacademy.dungeon.quest.Quest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameArea {

  private List<Player> players = new ArrayList<>();

  private LinkedList<AbstractEnemy> map = new LinkedList<>();

  public static void main(String... args) {
    System.out.println("Game startred!");

    GameArea gameArea = new GameArea();

    gameArea.initDefault();

    List<Player> players = List.of(new Player("Feri", true),
        new Player("Mate", false),
        new Player("Gyorgyi", false));

    List<Boolean> list = players.stream()
//        .filter(Predicate.not(Player::isKilled))
//        .filter(player -> !player.isKilled())
//        .filter(Player::isKilled)
//        .map(Player::getName)
        .map(Player::isKilled)
        .filter(value -> value)
        .collect(Collectors.toList());

    Set<String> set = new HashSet<>();
    set.add("123");
    set.add("asd");
    set.add("bsd");
    set.add("123");

    set.forEach(System.out::println);

    gameArea.readPlayers();

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
    return true;
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

  private void readPlayers() {
    // TODO read players
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
