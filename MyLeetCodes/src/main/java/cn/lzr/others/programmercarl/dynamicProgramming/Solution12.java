package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution12 {

  public static void main(String[] args) {
    int[] ints = {1, 2, 3};
    Solution12.combinationSum3(ints, 4);
  }

  // 求的是排列数目，所以先遍历背包再遍历物品
  public static int combinationSum4(int[] nums, int target) {
    // 确定dp数组
    int[] dp = new int[target + 1];

    // 初始化，例如当外层循环dp[1]时遍历到内存循环nums[0]，dp[ 1 - nums[0] ] = dp[0]
    // 就需要初始值dp[0] = 1
    dp[0] = 1;

    // 外层遍历背包
    for (int i = 1; i <= target; i++) {
      // 内层遍历物品
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] <= i) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }

    return dp[target];
  }

  // 求的是组合数目，所以和普通的一维dp背包问题一样（先遍历物品再遍历背包）
  public static int combinationSum3(int[] nums, int target) {
    // 确定dp数组
    int[] dp = new int[target + 1];

    // 初始化，例如当外层循环dp[1]时遍历到内存循环nums[0]，dp[ 1 - nums[0] ] = dp[0]
    // 就需要初始值dp[0] = 1
    dp[0] = 1;

    // 外层遍历物品
    for (int i = 0; i < nums.length; i++) {
      // 内层遍历背包
      for (int j = 1; j <= target; j++) {
        if (nums[i] <= j) {
          dp[j] += dp[j - nums[i]];
        }
      }
    }

    return dp[target];
  }
}
