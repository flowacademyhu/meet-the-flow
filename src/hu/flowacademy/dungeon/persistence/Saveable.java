package hu.flowacademy.dungeon.persistence;

import java.io.Serializable;
import java.util.Map;

public interface Saveable extends Serializable {

  Map<String, ? extends Serializable> getSaveables();

}
