package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphToSentenceParser extends AbstractTextParser {
  private static final Logger log = LogManager.getLogger();
  private static final String SENTENCE_REGEX = "[^.!?]+[.!?](\\s|$)";

  public ParagraphToSentenceParser() {
    super(SENTENCE_REGEX);
  }

  @Override
  protected TextComposite createContainer() {
    return new TextComposite();
  }
}