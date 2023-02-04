package cn.lzr.others.hot100;

public class Solution58 {
  // 零钱兑换
  int[] memo;

  public int coinChange(int[] coins, int amount) {
    if (coins.length == 0) {
      return -1;
    }
    memo = new int[amount];

    return findWay(coins, amount);
  }
  // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
  // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
  public int findWay(int[] coins, int amount) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }
    // 这里是自底向上的递归，例如memo[9]对应的值，一旦被确认则一定是最小的组合数
    if (memo[amount - 1] != 0) {
      return memo[amount - 1];
    }
    // 注意这个min值，初始确实是Integer.MAX_VALUE，指的是当前amount的最小组合数，但for循环遍历多次由所有coin情况一起确定
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      int res = findWay(coins, amount - coins[i]);
      if (res >= 0 && res < min) {
        // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
        min = res + 1;
      }
    }
    memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
    return memo[amount - 1];
  }

  public static void main(String[] args) {
    int[] coins = {2};

    coinChange2(coins, 3);
  }

  public static int coinChange2(int[] coins, int amount) {
    int[] dp = new int[amount + 1]; // dp
    int max = Integer.MAX_VALUE;

    // dp初始化
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      dp[i] = max;
    }

    // 先遍历背包，再遍历数组
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (coins[i] <= j && dp[j - coins[i]] != max) {
          dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
      }
    }

    return dp[amount] == max ? -1 : dp[amount];
  }
}
