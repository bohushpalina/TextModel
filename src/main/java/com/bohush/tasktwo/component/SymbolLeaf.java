package com.bohush.tasktwo.component;

public class SymbolLeaf implements TextComponent {

  private final char symbol;
  private final TextType type;

  public SymbolLeaf(char symbol, TextType type) {
    this.symbol = symbol;
    this.type = type;
  }

  @Override
  public int count() {
    return 1;
  }

  @Override
  public TextComponent add(TextComponent component) {
    throw new UnsupportedOperationException("Leaf cannot add children");
  }

  @Override
  public boolean remove(TextComponent component) {
    throw new UnsupportedOperationException("Leaf cannot remove children");
  }

  @Override
  public TextComponent getChild(int index) {
    throw new UnsupportedOperationException("Leaf has no children");
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }
}
