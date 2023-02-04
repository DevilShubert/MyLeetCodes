package cn.lzr.others.hot100;

public class Solution30 {
  // 这个对象将会被存在堆中

  public int numTrees(int n) {
    // dp[i]表示当有i个节点时所有的二插搜索树数目
    // dp[1] = 1； dp[2] = 2
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      // i必须等于当前节点数，讨论的是左右组合而不是左右数值
      for (int j = 0; j < i; j++) {
        // 例如i=3时，左右情况分别为：0+2、1+1、2+0（组合数 = i）
        // 例如i=4时，左右情况分别为：0+3、1+2、2+1、3+0
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }
}
