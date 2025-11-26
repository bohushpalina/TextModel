package com.bohush.tasktwo.component;
import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private List<TextComponent> components = new ArrayList<>();

  @Override
  public void operation() {
    for (TextComponent component : components) {
      component.operation();
    }
  }

  @Override
  public boolean add(TextComponent component) {
    return components.add(component);
  }

  @Override
  public boolean remove(TextComponent component) {
    return components.remove(component);
  }
}