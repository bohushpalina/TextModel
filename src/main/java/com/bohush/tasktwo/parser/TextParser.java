package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComponent;
import java.util.List;

public interface TextParser {
  void setNextParser(TextParser next);
  List<TextComponent> parse(String text);
}

