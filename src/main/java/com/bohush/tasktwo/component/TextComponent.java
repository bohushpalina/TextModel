package com.bohush.tasktwo.component;

public interface TextComponent {
  TextComponent add(TextComponent component);
  boolean remove(TextComponent component);
  TextComponent getChild(int index);
  int count();
  String toString();
}
