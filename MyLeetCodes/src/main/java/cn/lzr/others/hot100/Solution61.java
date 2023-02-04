package cn.lzr.others.hot100;

public class Solution61 {
  public static void main(String[] args) {
    int[] ints = {1, 2, 3, 1};
    rob(ints);
  }

  public static int rob(int[] nums) {
    int len = nums.length;
    if (len == 2) return nums[1] > nums[0] ? nums[1] : nums[0];
    int pre = robRange(nums, 0, len - 2);
    int in = robRange(nums, 1, len - 2);
    int post = robRange(nums, 1, len - 1);

    return Math.max(pre, Math.max(in, post));
  }

  public static int robRange(int[] nums, int begin, int end) {
    int len = end - begin + 1;
    int[] dp = new int[len + 1];

    dp[1] = nums[begin];

    for (int i = 2; i <= len; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[begin + i - 1]);
    }

    return dp[len];
  }
}
