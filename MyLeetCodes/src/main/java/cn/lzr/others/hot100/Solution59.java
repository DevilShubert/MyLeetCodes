package cn.lzr.others.hot100;

public class Solution59 {
  public static void main(String[] args) {
    numSquares(4);
  }

  public static int numSquares(int n) {

    int[] dp = new int[n + 1]; // dp

    // dp初始化
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i * i <= n; i++) { // 物品：也就是完全平方数从1开始，注意这里要 <= 背包总数
      for (int j = 1; j <= n; j++) { // 背包：背包也必须从1开始
        if (i * i <= j) {
          // 背包可以放下时
          dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        }
      }
    }

    return dp[n];
  }
}
