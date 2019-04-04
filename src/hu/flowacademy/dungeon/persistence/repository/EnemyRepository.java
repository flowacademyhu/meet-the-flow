package hu.flowacademy.dungeon.persistence.repository;

import hu.flowacademy.dungeon.Enemy;
import java.util.ArrayList;
import java.util.List;

public class EnemyRepository extends AbstractRepository<Enemy> {


  @Override
  protected List<Enemy> convertList(List<String> fileContent) {
    List<Enemy> enemies = new ArrayList<>();
    for (String line: fileContent) {
      Enemy enemy = null;
      if (line.startsWith("damage:")) {
        Integer damage = Integer.valueOf(getValue("damage:", line));
        if (enemy == null){
          enemy = new Enemy(null, null, damage);
          continue;
        }
        enemy.setDamage(damage);
      } else if (line.startsWith("name:")) {
        String name = getValue("name:", line);
        if (enemy == null) {
          enemy = new Enemy(name, null, 0);
          continue;
        }
        enemy.setName(name);
      } else if (AbstractRepository.MODEL_SEPARATOR.equals(line)) {
        enemies.add(enemy);
        enemy = null;
      }
     }
    return enemies;
  }

  private String getValue(String s, String line) {
    return line.substring(s.length());
  }

  @Override
  protected String getFileBasePath() {
    return "/tmp/flowgame";
  }
}
