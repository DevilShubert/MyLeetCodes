package cn.lzr.others.hot100;

public class Solution57 {
  public static void main(String[] args) {
    Solution57 solution57 = new Solution57();

    int[] ints = {1, 2, 3, 4, 3};
    Solution57.findDuplicate_mark(ints);
  }
  // Visited
  public static int findDuplicate_mark(int[] nums) {
    int len = nums.length;
    for (int num : nums) {
      int idx = Math.abs(num);
      if (nums[idx] < 0) {
        return idx;
      }
      nums[idx] = -nums[idx];
    }
    return 0;
  }
}
