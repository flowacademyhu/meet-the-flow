package hu.flowacademy.dungeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameArea {
  
  private List<Player> players = new ArrayList<>();
  
  private LinkedList<AbstractEnemy> enemies = new LinkedList<>();

  public static void main(String... args) {
    System.out.println("Game startred!");
    
    initDefault();

    readPlayers();

    mainLoop();
    
  }

  private static void mainLoop() {
    while (true) {
      if (gameEnded()) {
        break;
      }

      // getActualPlayer
      // getEnemyFromActualPosition
      //


    }
  }

  private static boolean gameEnded() {
    // TODO check players has all achievements
    // TODO check players are the end of the enemies
    return true;
  }

  private static void initDefault() {
    // TODO init map
  }

  private static void readPlayers() {
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
