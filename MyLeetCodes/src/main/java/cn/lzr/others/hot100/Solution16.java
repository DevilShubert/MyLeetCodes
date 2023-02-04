package cn.lzr.others.hot100;

public class Solution16 {
  // [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)
  public static void main(String[] args) {
    Solution16 solution16 = new Solution16();
  }

  public int search(int[] nums, int target) {
    int len = nums.length;
    if (len == 1) return nums[0] == target ? 0 : -1;

    int l = 0;
    int r = len - 1;
    int mid = (l + r) >> 1;

    while (l <= r) {
      if (nums[mid] == target) return mid;
      if (nums[l] <= nums[mid]) {
        if (nums[l] <= target && target <= nums[mid]) {
          r = mid - 1;
          mid = (l + r) >> 1;
        } else {
          l = mid + 1;
          mid = (l + r) >> 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[r]) {
          l = mid + 1;
          mid = (l + r) >> 1;
        } else {
          r = mid - 1;
          mid = (l + r) >> 1;
        }
      }
    }
    return -1;
  }
}
