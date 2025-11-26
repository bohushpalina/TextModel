package com.bohush.tasktwo.entity;
import com.bohush.tasktwo.component.TextComposite;

import java.util.Objects;

public class TextInfo {
  private String rawText;
  private TextComposite rootComponent;

  public TextInfo(String rawText, TextComposite rootComponent) {
    this.rawText = rawText;
    this.rootComponent = rootComponent;
  }

  public TextComposite getRootComponent() {
    return rootComponent;
  }

  public String getRawText() {
    return rawText;
  }

  public void setRawText(String rawText) {
    this.rawText = rawText;
  }

  public void setRootComponent(TextComposite rootComponent) {
    this.rootComponent = rootComponent;
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
