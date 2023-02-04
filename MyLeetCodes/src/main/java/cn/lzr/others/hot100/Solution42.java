package cn.lzr.others.hot100;

public class Solution42 {
  public static void main(String[] args) {
    Solution42 solution42 = new Solution42();
    int[] ints = {2, 3, -2, 4};
    solution42.maxProduct(ints);
  }

  public int maxProduct(int[] nums) {
    // dpMax[i]表示包含当前i结点的最大连续值
    // dpMin[i]表示当前当前i结点的最小连续值（由于i+1是负数时负负得正得到更大值）

    // 对于dpMax[i]和dpMin[i]的递推公式，两者可以互推

    if (nums.length == 0) return nums[0];

    int[] dpMax = new int[nums.length];
    int[] dpMin = new int[nums.length];

    dpMax[0] = nums[0];
    dpMin[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i]));
      dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
    }
    int max = Integer.MIN_VALUE;
    for (int temp : dpMax) {
      max = Math.max(temp, max);
    }
    return max;
  }
}
