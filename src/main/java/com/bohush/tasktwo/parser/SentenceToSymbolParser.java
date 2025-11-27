package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceToSymbolParser extends AbstractTextParser {
  private static final Logger log = LogManager.getLogger();
  private static final String PART_OF_SENTENCE_REGEX = "[\\S\\s]";

  public SentenceToSymbolParser() {
    super(PART_OF_SENTENCE_REGEX);
  }

  @Override
  public void setNextParser(TextParser successor) {
    log.warn("SentenceToSymbolParser is the last handler in the chain and cannot have a successor.");
    this.successor = null;
  }

  @Override
  protected TextComposite createContainer() {
    throw new UnsupportedOperationException("SymbolParser only creates leaf components.");
  }
}