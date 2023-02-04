package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution10 {
  // 最后一块石头的重量 II
  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int s : stones) {
      sum += s;
    }
    int target = sum >> 1;
    int len = stones.length;

    // 构造dp[i][j]表示在j重量下，包括物品0~i的最大重量
    // target + 1表示
    int[][] dp = new int[len][target + 1];

    // 初始化
    for (int j = 0; j <= target; j++) {
      if (j >= stones[0]) dp[0][j] = stones[0];
    }

    // 先遍历物品，再遍历重量，这一步其实就是完完全全的背包问题了
    for (int i = 1; i < len; i++) {
      for (int j = 1; j <= target; j++) {
        if (stones[i] <= j) {
          dp[i][j] = Math.max(stones[i] + dp[i - 1][j - stones[i]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return sum - 2 * dp[len - 1][target];
  }
}
