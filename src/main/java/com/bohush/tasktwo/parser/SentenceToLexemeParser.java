package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceToLexemeParser extends AbstractTextParser {
  private static final Logger log = LogManager.getLogger();

  private static final String LEXEME_REGEX = "[\\w\\d]+|[^\\w\\d\\s]+|\\s+";

  public SentenceToLexemeParser() {
    super(LEXEME_REGEX);
  }

  @Override
  protected TextComposite createContainer() {
    return new TextComposite();
  }
}