package com.bohush.tasktwo.component;

public class SymbolLeaf implements TextComponent {
  private char value;

  public SymbolLeaf(char value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public boolean add(TextComponent component) {
    return false;
  }

  @Override
  public boolean remove(TextComponent component) {
    return false;
  }
}