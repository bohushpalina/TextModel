package com.bohush.tasktwo.service;
import com.bohush.tasktwo.component.TextComponent;
import com.bohush.tasktwo.exception.TextException;

public interface TextService {
  public TextComponent processText(String filePath) throws TextException;
  public String restoreText(TextComponent rootComposite);
}
