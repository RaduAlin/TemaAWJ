package hello;

import java.util.List;
import java.util.ArrayList;

public class Fruct {
  private String name;
  private int id;

  public Fruct() {}

  public Fruct(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
}