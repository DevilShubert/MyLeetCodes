package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution11 {
  public static void main(String[] args) {
    testCompletePack();
  }

  private static void testCompletePack() {
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    int bagWeight = 4;
    int[] dp = new int[bagWeight + 1];
    for (int i = 0; i < weight.length; i++) { // 遍历物品
      for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
    }
    for (int maxValue : dp) {
      System.out.println(maxValue + "   ");
    }
  }
}
