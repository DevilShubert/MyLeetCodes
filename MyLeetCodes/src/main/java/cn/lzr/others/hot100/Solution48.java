package cn.lzr.others.hot100;

public class Solution48 {
  public static void main(String[] args) {
    Solution48 solution48 = new Solution48();

    Trie trie = new Trie();
    trie.insert("app");
    trie.insert("apple");
    trie.insert("add");
    System.out.println(trie.search("app"));
  }
}

class Trie {

  class TireNode {
    private boolean isEnd;
    TireNode[] next;

    public TireNode() {
      isEnd = false;
      next = new TireNode[26];
    }
  }

  private TireNode root;

  public Trie() {
    root = new TireNode();
  }

  public void insert(String word) {
    TireNode cur = root;
    char[] chars = word.toCharArray();
    for (char c : chars) {
      // 说明当前开头的单词还没有储存过
      if (cur.next[c - 'a'] == null) {
        TireNode next = new TireNode();
        cur.next[c - 'a'] = next;
        cur = next;
      } else {
        cur = cur.next[c - 'a'];
      }
    }
    // 作为末尾字母都要置为End
    cur.isEnd = true;
  }

  public boolean search(String word) {
    TireNode cur = root;
    char[] chars = word.toCharArray();
    for (char c : chars) {
      TireNode next = cur.next[c - 'a'];
      if (next == null) return false;
      cur = next;
    }
    return cur.isEnd;
  }

  public boolean startsWith(String prefix) {
    TireNode cur = root;
    char[] chars = prefix.toCharArray();
    for (char c : chars) {
      TireNode next = cur.next[c - 'a'];
      if (next == null) return false;
      cur = next;
    }
    return true;
  }
}
