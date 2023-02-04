package cn.lzr.others.programmercarl.dynamicProgramming;

public class Solution09 {
  // 分割等和子集
  public static void main(String[] args) {
    Solution09 solution09 = new Solution09();
    int[] ints = {1, 5, 11, 5};
    solution09.canPartition(ints);
  }

  public boolean canPartition(int[] nums) {
    // 判空
    int len = nums.length;
    if (len == 1) return false;

    // 总和
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    if (sum % 2 == 1) return false;

    // 还是使用二维数组，确定dp数组含义（重点背包最大重量为target）
    int target = sum >> 1;
    // dp[i][j]表示在当前0~i的物品中，重量为j的背包所能装的最大价值物品
    int[][] dp = new int[len][target + 1];

    // 初始化，数组第一列全为0，dp[0][j]按照按照情况确定
    for (int j = 1; j < target + 1; j++) {
      if (nums[0] <= j) dp[0][j] = nums[0];
    }

    // 先遍历物品，再遍历背包
    for (int i = 1; i < len; i++) {
      for (int j = 0; j < target + 1; j++) {
        if (nums[i] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
        }
      }
    }

    return dp[len - 1][target] == target;
  }
}
