package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.SymbolLeaf;
import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import com.bohush.tasktwo.component.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTextParser implements TextParser {

  private static final Logger log = LogManager.getLogger();
  protected TextParser successor;
  protected final Pattern pattern;
  protected final TextType type;

  protected AbstractTextParser(String regex, TextType type) {
    this.pattern = Pattern.compile(regex);
    this.type = type;
  }

  @Override
  public void setNextParser(TextParser successor) {
    this.successor = successor;
  }

  @Override
  public List<TextComponent> parse(String text) {

    List<TextComponent> result = new ArrayList<>();
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
      String fragment = matcher.group();
      if (successor == null) {
        result.addAll(parseSymbols(fragment));
        continue;
      }
      TextComposite composite = new TextComposite(type);
      List<TextComponent> children = successor.parse(fragment);
      for (TextComponent c : children) {
        composite.add(c);
      }
      result.add(composite);
    }
    return result;
  }

  private List<TextComponent> parseSymbols(String fragment) {
    List<TextComponent> symbols = new ArrayList<>();
    for (char c : fragment.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        symbols.add(new SymbolLeaf(c, TextType.LETTER));
      } else {
        symbols.add(new SymbolLeaf(c, TextType.PUNCTUATION));
      }
    }
    return symbols;
  }
}
