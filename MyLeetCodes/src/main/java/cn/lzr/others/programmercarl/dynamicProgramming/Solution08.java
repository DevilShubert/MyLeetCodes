package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution08 {
  // 测试背包问题
  public static void main(String[] args) {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int bagsize = 4;
    testweightbagproblem(weight, value, bagsize);
  }

  public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
    // 初始化dp数组
    // dp[i][j]含：在当前j重量下从0~i所有物品中所能拿到的最大价值
    // j代表的是背包，i代表的是重量
    int len = value.length;
    int[][] dp = new int[len][bagsize + 1];

    // dp初始化，第一列的数据肯定是0
    for (int i = 0; i < len; i++) {
      dp[i][0] = 0;
    }

    // 先遍历j：背包重量；再遍历i物品
    for (int j = 1; j < bagsize + 1; j++) {
      for (int i = 0; i < len; i++) {
        if (i == 0 && weight[i] > j) {
          // 第一个物品，且重量超过背包当前所能装的最大重量
          // 之所以要将第一个物品提出来是因为不能获得i-1的下标
          dp[i][j] = 0;
        } else if (i == 0 && weight[i] <= j) {
          // 第一个物品，重量没有超过背包当前所能装的最大重量
          dp[i][j] = value[i];
        } else if (j >= weight[i]) {
          // 不是第一个物品，当前物品重量小于背包所能装对大重量，且通过比较是否装这个物品来确定当前dp[i][j]
          dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
        } else {
          // 不是第一个物品，但背包装不下
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    for (int i = 0; i < len; i++) {
      for (int j = 0; j <= bagsize; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
