package com.bohush.tasktwo.component;

public interface TextComponent {
  @Override
  String toString();
  boolean add(TextComponent component);
  boolean remove(TextComponent component);
}


