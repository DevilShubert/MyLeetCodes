package cn.lzr.others.hot100;

public class Solution55 {
  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] cur : matrix) {
      if (search(cur, target)) return true;
    }
    return false;
  }

  public boolean search(int[] nums, int target) {
    int len = nums.length;
    int r = len - 1;
    int l = 0;

    while (l <= r) {
      int mid = (l + r) >> 1;
      if (nums[mid] == target) {
        return true;
      } else if (target < nums[mid]) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return false;
  }
}
