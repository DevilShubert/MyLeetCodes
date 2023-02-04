package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution14 {
  // 零钱兑换
  static int res = Integer.MAX_VALUE;

  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    coinChange2(coins, 100);
  }

  // 零钱兑换，动规版本，说实话真的不好写不如递归版本
  public static int coinChange1(int[] coins, int amount) {
    int max = Integer.MAX_VALUE;
    int[] dp = new int[amount + 1];
    // 初始化dp数组为最大值
    for (int j = 0; j < dp.length; j++) {
      dp[j] = max;
    }
    // 当金额为0时需要的硬币数目为0
    dp[0] = 0;
    // 外层遍历物品
    for (int i = 0; i < coins.length; i++) {
      // 正序遍历：完全背包每个硬币可以选择多次
      for (int j = coins[i]; j <= amount; j++) {
        // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
        if (dp[j - coins[i]] != max) {
          // 选择硬币数目最小的情况
          dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
      }
    }
    return dp[amount] == max ? -1 : dp[amount];
  }

  // 递归版本，但是会超时
  public static int coinChange2(int[] coins, int amount) {
    // 递归寻找
    findWay(coins, amount, 0);

    if (res == Integer.MAX_VALUE) {
      //  结果判断，没有一种合适的组合方法
      return -1;
    }

    return res;
  }

  public static void findWay(int[] coins, int amount, int count) {
    if (amount == 0) {
      res = Math.min(res, count);
      return;
    }
    if (amount < 0) {
      return;
    }

    // 本层循环，因为硬币是无限的所以for循环遍历硬币
    for (int i = 0; i < coins.length; i++) {
      findWay(coins, amount - coins[i], count + 1);
    }
  }
}
