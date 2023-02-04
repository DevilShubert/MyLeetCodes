package cn.lzr.others.hot100;

public class Solution20 {
  // [最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)
  public int maxSubArray(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];
    // dp[i] 表示以第i个元素结尾的最大子数组和
    int[] dp = new int[len];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < len; i++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
