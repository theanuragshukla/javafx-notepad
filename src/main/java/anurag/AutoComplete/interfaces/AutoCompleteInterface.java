package anurag.AutoComplete.interfaces;

import java.util.List;

public interface AutoCompleteInterface {
  void feedFile(String fileName);
  List<String> search(String prefix);
  List<String> search(String prefix, int count);
  void acceptSuggestion(String word);
}
