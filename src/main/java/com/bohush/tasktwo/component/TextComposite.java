package com.bohush.tasktwo.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

  private static final Logger log = LogManager.getLogger(TextComposite.class);

  public static final String TEXT_SEPARATOR = "\n\n";
  public static final String PARAGRAPH_INDENT = "\t";
  public static final String SENTENCE_SEPARATOR = " ";
  public static final String EMPTY_STRING = "";

  private final TextType type;
  private final List<TextComponent> components = new ArrayList<>();

  public TextComposite(TextType type) {
    this.type = type;
  }
  // ... (методы add, remove, getChild, count без изменений)

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
    return components.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    switch (type) {
      case TEXT -> {
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append(TEXT_SEPARATOR);
        }
      }

      case PARAGRAPH -> {
        sb.append(PARAGRAPH_INDENT);
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append(SENTENCE_SEPARATOR);
        }
      }

      case SENTENCE -> {
        // ВОССТАНОВЛЕНО: Простая логика, так как LEXEME теперь содержит знак препинания.
        for (int i = 0; i < components.size(); i++) {
          sb.append(components.get(i).toString());
          if (i != components.size() - 1)
            sb.append(SENTENCE_SEPARATOR);
        }
      }

      case LEXEME, WORD -> {
        for (TextComponent c : components) {
          sb.append(c.toString());
        }
      }

      case LETTER, PUNCTUATION -> {
        return EMPTY_STRING;
      }
    }

    return sb.toString();
  }
}