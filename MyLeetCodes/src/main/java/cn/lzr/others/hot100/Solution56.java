package cn.lzr.others.hot100;

public class Solution56 {
  // 移动零
  public void moveZeroes(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    // 在外层每次都要遍历right
    while (right < n) {
      // 在内层交换之后移动left
      if (nums[right] != 0) {
        swap(nums, left, right);
        left++;
      }
      right++;
    }
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public void moveZeroes2(int[] nums) {
    // 双指针一次遍历
    int b = 0;
    // 主指针一次遍历
    for (int a = 0; a < nums.length; a++) {
      if (nums[a] != 0) {
        nums[b] = nums[a];
        b++;
      }
    }

    // 覆盖剩余位置
    for (; b < nums.length; b++) {
      nums[b] = 0;
    }
  }
}
