package com.bohush.tasktwo.entity;
import com.bohush.tasktwo.component.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TextInfo {
  private static final Logger log = LogManager.getLogger();
  private String rawText;
  private TextComposite rootComponent;

  public TextInfo(String rawText, TextComposite rootComponent) {
    this.rawText = rawText;
    this.rootComponent = rootComponent;
    log.info("TextInfo entity created successfully.");
  }

  public TextComposite getRootComponent() {
    return rootComponent;
  }

  public String getRawText() {
    return rawText;
  }

  public void setRawText(String rawText) {
    this.rawText = rawText;
    log.info("Raw text updated in TextInfo.");
  }

  public void setRootComponent(TextComposite rootComponent) {
    this.rootComponent = rootComponent;
    log.info("Root component updated in TextInfo.");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TextInfo textInfo = (TextInfo) o;
    return Objects.equals(getRawText(), textInfo.getRawText()) && Objects.equals(getRootComponent(), textInfo.getRootComponent());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRawText(), getRootComponent());
  }

  @Override
  public String toString() {
    return "TextInfo{" +
            "rawText='" + rawText + '\'' +
            ", rootComponent=" + rootComponent +
            '}';
  }
}
