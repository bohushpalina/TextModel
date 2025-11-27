package com.bohush.tasktwo.reader.impl;
import com.bohush.tasktwo.exception.TextException;
import com.bohush.tasktwo.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TextReaderImpl implements TextReader {
  private static final Logger log = LogManager.getLogger();

  @Override
  public String readFile(String filePath) throws TextException
  {
    Path path = Paths.get(filePath);
    try
    {
      String fullText = Files.readString(path);
      log.info("File read successfully. Length: {} chars", fullText.length());
      return fullText;
    }
    catch (IOException e)
    {
      throw new TextException("Reading file exception: " + filePath, e);
    }
  }
}
