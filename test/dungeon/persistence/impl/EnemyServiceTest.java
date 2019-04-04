package dungeon.persistence.impl;

import hu.flowacademy.dungeon.Enemy;
import hu.flowacademy.dungeon.persistence.CrudService;
import hu.flowacademy.dungeon.persistence.impl.EnemyService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class EnemyServiceTest {

  private Enemy enemy = new Enemy("Dalek", null, 1000);
  private CrudService<Enemy> enemyCrudService = new EnemyService();

  @Test
  public void testSave() {
    Enemy savedEnemy = enemyCrudService.save(this.enemy);
    Assertions.assertNotNull(savedEnemy);
  }

  @Test
  public void testRead() {
    List<Enemy> enemies = enemyCrudService.read();
    Assertions.assertNotEquals(0, enemies.size());
  }


}
