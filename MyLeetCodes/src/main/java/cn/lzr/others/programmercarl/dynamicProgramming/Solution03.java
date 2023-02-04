package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution03 {
  public static void main(String[] args) {
    //
    Solution03 solution03 = new Solution03();
    int[] ints = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    solution03.minCostClimbingStairs(ints);
  }

  public int minCostClimbingStairs(int[] cost) {
    if (cost.length == 2) return Math.min(cost[0], cost[1]);
    int loop = cost.length + 1;
    int[] dp = new int[loop];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < loop; i++) {
      if (i == loop - 1) {
        dp[i] = Math.min(dp[i - 1], dp[i - 2]);
      } else {
        dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
      }
    }
    return dp[loop - 1];
  }
}
