package com.bohush.tasktwo.service.impl;

import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import com.bohush.tasktwo.exception.TextException;
import com.bohush.tasktwo.parser.TextParserChain;
import com.bohush.tasktwo.reader.TextReader;
import com.bohush.tasktwo.reader.impl.TextReaderImpl;
import com.bohush.tasktwo.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextServiceImpl implements TextService {
  private static final Logger log = LogManager.getLogger();

  private final TextReader reader;
  private final TextParserChain parserChain;

  public TextServiceImpl() {
    this.reader = new TextReaderImpl();
    this.parserChain = new TextParserChain();
    log.info("TextService initialized. Parser chain configured.");
  }

  @Override
  public TextComponent processText(String filePath) throws TextException {
    String rawText = reader.read(filePath);
    log.info("File read successfully.");
    TextComponent rootComposite = parserChain.parse(rawText);
    log.info("Text parsed into composite structure.");
    return rootComposite;
  }

  @Override
  public String restoreText(TextComponent rootComposite) {
    if (rootComposite == null) {
      log.warn("Cannot restore text: rootComposite is null.");
      return "";
    }
    String restoredText = rootComposite.toString();
    log.info("Text restored successfully.");
    return restoredText;
  }
}
