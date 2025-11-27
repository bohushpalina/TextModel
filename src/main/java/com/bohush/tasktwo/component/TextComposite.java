package com.bohush.tasktwo.component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private static final Logger log = LogManager.getLogger(TextComposite.class);
  private List<TextComponent> components = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (TextComponent component : components) {
      sb.append(component.toString());
    }
    return sb.toString();
  }

  @Override
  public boolean add(TextComponent component) {
    boolean result = components.add(component);
    log.info("Component added to TextComposite: {}", result);
    return result;
  }

  @Override
  public boolean remove(TextComponent component) {
    boolean result = components.remove(component);
    log.info("Component removed from TextComposite: {}", result);
    return result;
  }
}