package cn.lzr.others.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution60 {
  // 139 单词拆分：这道题有特殊性，需要只遍历背包才好做

  public boolean wordBreak(String s, List<String> wordDict) {
    // 只遍历背包
    // dp数组dp[i]表示到当前长度的字符串中是否可以进行单词拆分
    int len = s.length();
    boolean[] dp = new boolean[len + 1];

    // 初始化
    dp[0] = true;

    // 只遍历背包
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j < i; j++) {
        // 通过"catsandog" + ["cats","dog","sand","and","cat"]
        // 这个案例理解为什么需要有 && dp[j] == true这一步，这个思想和零钱兑换时很想，概括的说就是为了让上一个状态可以达到
        if (wordDict.contains(s.substring(j, i)) && dp[j] == true) {
          dp[i] = true;
        }
      }
    }

    return dp[s.length()];
  }

  public boolean wordBreak2(String s, List<String> wordDict) {
    // 先遍历物品再遍历背包
    int maxWordLength = 0;
    Set<String> wordSet = new HashSet<>(wordDict.size());
    for (String word : wordDict) {
      wordSet.add(word);

      if (word.length() > maxWordLength) {
        maxWordLength = word.length();
      }
    }

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i < dp.length; i++) {
      for (int j = (i - maxWordLength < 0 ? 0 : i - maxWordLength); j < i; j++) {
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}
