package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution13 {
  // 爬楼梯改进版本,m为最大步数，n为最大楼梯数目
  public static int climbStairsPro(int m, int n) {
    // 确定dp数组
    int[] dp = new int[n + 1];

    // 初始化，例如当外层循环dp[1]时遍历到内存循环nums[0]，dp[ 1 - nums[0] ] = dp[0]
    // 就需要初始值dp[0] = 1
    dp[0] = 1;

    // 外层遍历物品
    for (int i = 0; i < m; i++) {
      // 内层遍历背包
      for (int j = 1; j <= n; j++) {
        if (i <= j) {
          dp[j] += dp[j - i];
        }
      }
    }

    return dp[n];
  }
}
