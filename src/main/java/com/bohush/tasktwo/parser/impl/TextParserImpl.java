package com.bohush.tasktwo.parser.impl;

import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import com.bohush.tasktwo.component.TextType;
import com.bohush.tasktwo.component.SymbolLeaf;
import com.bohush.tasktwo.parser.AbstractTextParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class TextParserImpl extends AbstractTextParser {
  public TextParserImpl(String regex, TextType type) {
    super(regex, type);
  }
  @Override
  public List<TextComponent> parse(String text) {
    return super.parse(text);
  }
}
