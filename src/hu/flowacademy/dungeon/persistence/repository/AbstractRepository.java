package hu.flowacademy.dungeon.persistence.repository;

import hu.flowacademy.dungeon.persistence.Saveable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class AbstractRepository<M extends Saveable> {

  public static final String MODEL_SEPARATOR = "---";

  public M save(M model) {
    File parent = new File(getFileBasePath());
    if (!parent.exists() && !parent.mkdirs()) {
      return null;
    }
    try {
      Path file = Paths
          .get(parent.getPath() + File.separator + model.getClass().getSimpleName() + ".txt");
      Files.write(file, convertWriteable(model.getSaveables()), Charset.forName("UTF-8"));
    } catch (IOException e) {
      System.err.println("Invalid file write at: " + model.getClass().getSimpleName());
      return null;
    }

    return model;
  }

  private List<String> convertWriteable(Map<String, ? extends Serializable> saveables) {
    List<String> collect = saveables.entrySet().stream()
        .map(this::mergeKeyAndValue)
        .collect(Collectors.toList());
    collect.add(MODEL_SEPARATOR);
    return collect;
  }

  private String mergeKeyAndValue(Entry<String, ? extends Serializable> entry) {
    return entry.getKey() + ":" + entry.getValue();
  }

  public M update(M model) {
    List<M> models = this.read((Class<M>) model.getClass());
    List<M> changedModels = models.stream().peek(item -> {
      if (item.equals(model)) {
        item = model;
      }
      return;
    }).collect(Collectors.toList());
    System.err.println(changedModels);
    save(changedModels);
    return model;
  }

  private void save(List<M> changedModels) {

  }

  public List<M> read(Class<M> mClass) {
    File parent = new File(getFileBasePath());
    if (!parent.exists()) {
      return List.of();
    }
    try {
      Path file = Paths.get(parent.getPath() + File.separator + mClass.getSimpleName() + ".txt");
      List<String> fileContent = Files.readAllLines(file);
      return convertList(fileContent);
    } catch (IOException e) {
      System.err.println("Invalid file read: " + mClass.getSimpleName());
    }
    return List.of();
  }

  protected abstract List<M> convertList(List<String> fileContent);

  public boolean delete(M model) {
    return false;
  }

  protected abstract String getFileBasePath();

}
