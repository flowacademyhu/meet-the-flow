package hu.flowacademy.dungeon.persistence.impl;

import hu.flowacademy.dungeon.Enemy;
import hu.flowacademy.dungeon.persistence.CrudService;
import hu.flowacademy.dungeon.persistence.repository.AbstractRepository;
import hu.flowacademy.dungeon.persistence.repository.EnemyRepository;
import java.util.List;

public class EnemyService implements CrudService<Enemy> {

  AbstractRepository<Enemy> enemyRepository = new EnemyRepository();

  @Override
  public Enemy save(Enemy model) {
    return enemyRepository.save(model);
  }

  @Override
  public Enemy update(Enemy model) {
    return null;
  }

  @Override
  public List<Enemy> read() {
    return enemyRepository.read(Enemy.class);
  }

  @Override
  public boolean delete(Enemy model) {
    return false;
  }
}
