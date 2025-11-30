package com.bohush.tasktwo.parser;

import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.component.TextComposite;
import com.bohush.tasktwo.component.TextType;
import com.bohush.tasktwo.parser.impl.TextParserImpl;

import java.util.List;

public class TextParserChain {
  private TextParser first;

  public TextParserChain() {
    TextParser text = new TextParserImpl(TextRegex.TEXT, TextType.TEXT);
    TextParser paragraph = new TextParserImpl(TextRegex.PARAGRAPH, TextType.PARAGRAPH);
    TextParser sentence = new TextParserImpl(TextRegex.SENTENCE, TextType.SENTENCE);
    TextParser word = new TextParserImpl(TextRegex.LEXEME, TextType.WORD);
    TextParser symbol = new TextParserImpl(TextRegex.SYMBOL, TextType.LETTER); // Новый уровень

    text.setNextParser(paragraph);
    paragraph.setNextParser(sentence);
    sentence.setNextParser(word);
    word.setNextParser(symbol); // WORD теперь ссылается на SYMBOL

    this.first = text;
  }

  public TextComponent parse(String text) {
    TextComposite root = new TextComposite(TextType.TEXT);
    List<TextComponent> children = first.parse(text);
    children.forEach(root::add);
    return root;
  }
}