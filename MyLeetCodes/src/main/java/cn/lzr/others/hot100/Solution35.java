package cn.lzr.others.hot100;

public class Solution35 {

  public int maxProfit(int[] prices) {

    // dp[i][0]表示第i填持有股票时最大钱数
    // dp[i][1]表示第i填不持有股票时最大钱数
    int[][] dp = new int[prices.length][2];

    // 初始化：第1天dp[0][0] = -p[0]; dp[0][1] = 0

    dp[0][0] = -1 * prices[0];
    dp[0][1] = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < 2; j++) {
        // 地推公式
        // 持有：dp[i][0] = Math.max(dp[i-1][0], -p[i]) 即买入
        // 不持有：dp[i][1] = Math.max(dp[i-1][1], p[i] + dp[i-1][0]) 即卖出
        if (j == 0) {
          dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
          if (max < dp[i][0]) max = dp[i][0];
        }
        if (j == 1) {
          dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
          if (max < dp[i][1]) max = dp[i][1];
        }
      }
    }
    if (max < 0) return 0;
    return max;
  }
}
