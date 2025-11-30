package com.bohush.tasktwo.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

  private static final Logger log = LogManager.getLogger(TextComposite.class);

  private final TextType type;
  private final List<TextComponent> components = new ArrayList<>();

  public TextComposite(TextType type) {
    this.type = type;
  }

  @Override
  public TextComponent add(TextComponent component) {
    components.add(component);
    return component;
  }

  @Override
  public boolean remove(TextComponent component) {
    return components.remove(component);
  }

  @Override
  public TextComponent getChild(int index) {
    return components.get(index);
  }

  @Override
  public int count() {
    return components.stream().mapToInt(TextComponent::count).sum();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    switch (type) {

      case TEXT -> {
        // paragraphs separated by newline
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append("\n");
        }
      }

      case PARAGRAPH -> {
        sb.append("\t"); // indent
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append(" ");
        }
      }

      case SENTENCE -> {
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append(" ");
        }
      }

      case LEXEME -> {
        for (TextComponent c : components) {
          sb.append(c.toString());
        }
      }

      case WORD -> {
        for (TextComponent c : components) {
          sb.append(c.toString());
        }
      }

      case LETTER, PUNCTUATION -> {
        return components.isEmpty() ? "" : components.get(0).toString();
      }
    }

    return sb.toString();
  }
}
