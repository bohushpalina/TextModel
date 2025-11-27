package com.bohush.tasktwo.reader;
import com.bohush.tasktwo.exception.TextException;

public interface TextReader {
  public String read(String filePath) throws TextException;;
}
