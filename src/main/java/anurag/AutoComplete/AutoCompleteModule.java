package anurag.AutoComplete;
import java.util.*;

public class AutoCompleteModule {
  private AutoComplete ac;

  private void train(String file){
    this.ac.feedFile(file);
  }

  public AutoCompleteModule() {
    this.ac = new AutoComplete();
    this.train("words.txt");
  }

  public List<String> search(String prefix) {
    List<String> result = new ArrayList<>();
    if(prefix !=null && !prefix.isEmpty()) {
      result = ac.search(prefix);
    }
    return result;
  }

  public void accept(String acceptedWord) {
    ac.insert(acceptedWord);
  }
}
