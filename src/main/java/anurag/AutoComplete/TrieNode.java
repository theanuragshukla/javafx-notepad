package anurag.AutoComplete;

import java.util.*;

public class TrieNode implements Comparable<TrieNode> {
  char c;
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  PriorityQueue<TrieNode> order = new PriorityQueue<TrieNode>();
  int wordsAhead;
  int wordCount;

  public TrieNode() {}
  public TrieNode(char c){
    this.c = c;
  }

  public List<TrieNode> getWordsAhead(int count){
    List<TrieNode> result = new ArrayList<TrieNode>();
    while (count > 0 && !order.isEmpty()){
      TrieNode node = order.poll();
      result.add(node);
      count-= node.wordsAhead;
    }
    return result;
  }

  public List<TrieNode> getWordsAhead(){
    return getWordsAhead(5);
  }

  public List<String> getAllWords(int c, String prefix){
    List<String> result = new ArrayList<String>();
    dfs(this, prefix, result, c);
    return result;
  }

  private void dfs(TrieNode current, String prefix, List<String> result, int count){
    // System.out.println("dfs " + current + " " + prefix + " " + count +" "+ result );
    List<TrieNode> wordsAhead = current.getWordsAhead(count);
    for (TrieNode node : wordsAhead){
      if (node.wordCount > 0){
        result.add(prefix + node.c);
        count--;
      }
      dfs(node, prefix + node.c, result, count);
    }
  }


  @Override
  public String toString(){
    return String.format("%c %d %d", c, wordCount , wordsAhead);
  }

  @Override
  public int compareTo(TrieNode o) {
    return o.wordsAhead - this.wordsAhead;
  }
}
