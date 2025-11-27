package com.bohush.tasktwo.service;
import com.bohush.tasktwo.entity.TextInfo;
import com.bohush.tasktwo.exception.TextException;

public interface TextService {
  TextInfo processText(String filePath) throws TextException;
  String restoreText(TextInfo textInfo);
}
