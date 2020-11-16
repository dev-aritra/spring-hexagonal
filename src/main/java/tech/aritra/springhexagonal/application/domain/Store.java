package tech.aritra.springhexagonal.application.domain;

import org.springframework.util.StringUtils;

public class Store {
  private String id;
  private final String name;
  private final Location location;

  public Store(String name, Location location) {
    this.name = name;
    this.location = location;
  }

  public Store(String id, String name, Location location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  public boolean isValid() {
    return StringUtils.hasText(name) && location.isValid();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Location getLocation() {
    return location;
  }
}
