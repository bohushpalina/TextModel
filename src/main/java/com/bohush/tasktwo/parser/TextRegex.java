package com.bohush.tasktwo.parser;

public class TextRegex {
  public static final String TEXT = "(.+(\\r?\\n|$))";
  public static final String PARAGRAPH = "[^.!?]+[.!?]";
  public static final String SENTENCE = "\\S+";
  public static final String LEXEME = ".";
}
