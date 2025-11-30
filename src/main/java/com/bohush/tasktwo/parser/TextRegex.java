package com.bohush.tasktwo.parser;

public class TextRegex {
  public static final String TEXT = "(.+(\\r?\\n|$))";
  public static final String PARAGRAPH = "([^.!?]+[.!?]+)\\s*";
  public static final String SENTENCE = "([\\w'-]+(?:[.,:;!?%]+)?|[^\\w\\s]+)";
  public static final String LEXEME = "([\\w'-]+(?:[.,:;!?%]+)?|[^\\w\\s]+)";
  public static final String SYMBOL = ".";
}