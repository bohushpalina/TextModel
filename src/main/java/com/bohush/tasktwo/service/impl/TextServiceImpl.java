package com.bohush.tasktwo.service.impl;
import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import com.bohush.tasktwo.entity.TextInfo;
import com.bohush.tasktwo.exception.TextException;
import com.bohush.tasktwo.parser.*;
import com.bohush.tasktwo.reader.TextReader;
import com.bohush.tasktwo.reader.impl.TextReaderImpl;
import com.bohush.tasktwo.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.StringJoiner;

public class TextServiceImpl implements TextService {
  private static final Logger log = LogManager.getLogger();

  private TextReader reader;
  private TextParser rootParser;

  public TextServiceImpl() {
    this.reader = new TextReaderImpl();
    TextParser symbolParser = new LexemeToSymbolParser();
    TextParser lexemeParser = new SentenceToLexemeParser();
    TextParser sentenceParser = new ParagraphToSentenceParser();
    this.rootParser = new TextToParagraphParser();

    rootParser.setNextParser(sentenceParser);
    sentenceParser.setNextParser(lexemeParser);
    lexemeParser.setNextParser(symbolParser);
    log.info("TextService initialized. Parser chain configured.");
  }

  @Override
  public TextInfo processText(String filePath) throws TextException {
    String rawText = reader.read(filePath);
    List<TextComponent> components = rootParser.parse(rawText);
    TextComposite rootComposite = new TextComposite();
    for (TextComponent component : components) {
      rootComposite.add(component);
    }
    TextInfo result = new TextInfo(rawText, rootComposite);
    log.info("Text processing finished. Root composite created.");
    return result;
  }

  @Override
  public String restoreText(TextInfo textInfo) {
    if (textInfo == null || textInfo.getRootComponent() == null) {
      log.warn("Cannot restore text: TextInfo or RootComponent is null.");
      return "";
    }
    TextComposite root = textInfo.getRootComponent();
    String restoredText = root.toString();
    log.info("Text restored successfully. Length: {} chars. Text: {}", restoredText.length(), restoredText);
    return restoredText;
  }
}