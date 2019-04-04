package hu.flowacademy.dungeon.persistence;

import hu.flowacademy.dungeon.AbstractEnemy;
import java.util.List;

public interface CrudService<M extends Saveable> {

  M save(M model);

  M update(M model);

  List<M> read();

  boolean delete(M model);

}
