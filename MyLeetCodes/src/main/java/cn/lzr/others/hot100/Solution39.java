package cn.lzr.others.hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution39 {
  // 单词拆分
  public static void main(String[] args) {
    Solution39 solution39 = new Solution39();
    List<String> strings =
        Arrays.asList(
            "a",
            "aa",
            "aaa",
            "aaaa",
            "aaaaa",
            "aaaaaa",
            "aaaaaaa",
            "aaaaaaaa",
            "aaaaaaaaa",
            "aaaaaaaaaa");
    System.out.println(
        solution39.wordBreak(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
            strings));
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> hashSet = new HashSet<String>(wordDict);
    return dfs(s, 0, s.length(), hashSet);
  }

  public boolean dfs(String s, int start, int len, HashSet<String> hashSet) {
    // 中止条件：匹配完成
    if (start == s.length()) return true;

    boolean flag = false;

    // 当前层遍历,substring左闭右开
    for (int i = start; i < len; i++) {
      String curStr = s.substring(start, i + 1);
      if (!hashSet.contains(curStr)) continue;
      flag = flag || dfs(s, i + 1, len, hashSet);
    }
    return flag;
  }
}
