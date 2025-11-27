package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.SymbolLeaf;
import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTextParser implements TextParser {
  private static final Logger log = LogManager.getLogger();
  protected TextParser successor;
  protected String regex;

  public AbstractTextParser(String regex) {
    this.regex = regex;
  }

  @Override
  public void setNextParser(TextParser successor) {
    this.successor = successor;
    log.info("{} set successor to {}", this.getClass().getSimpleName(), successor.getClass().getSimpleName());
  }

  @Override
  public List<TextComponent> parse(String text) {
    List<TextComponent> components = new ArrayList<>();
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    log.info("{} starts parsing.", this.getClass().getSimpleName());

    while (matcher.find())
    {
      String part = matcher.group();
      if (!part.isEmpty()) {
        if (successor != null) {
          List<TextComponent> subComponents = successor.parse(part);
          TextComposite container = createContainer();
          for (TextComponent subComponent : subComponents)
          {
            container.add(subComponent);
          }
          components.add(container);
        }
        else {
          for (char c : part.toCharArray())
          {
            TextComponent leaf = new SymbolLeaf(c);
            components.add(leaf);
          }
        }
      }
    }
    return components;
  }


  protected TextComposite createContainer() {
    return new TextComposite();
  }
}