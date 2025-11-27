package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextToParagraphParser extends AbstractTextParser {
  private static final Logger log = LogManager.getLogger();
  private static final String PARAGRAPH_REGEX = "(.+(\\n|\\r\\n|\\r|$))";
  public TextToParagraphParser() {
    super(PARAGRAPH_REGEX);
  }

  @Override
  protected TextComposite createContainer() {
    return new TextComposite();
  }
}