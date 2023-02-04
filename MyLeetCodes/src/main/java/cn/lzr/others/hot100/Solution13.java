package cn.lzr.others.hot100;

import java.util.Arrays;

public class Solution13 {
  // [下一个排列（技巧类题目）](https://leetcode-cn.com/problems/next-permutation/)

  public static void main(String[] args) {
    //    int[] ints = {1, 2, 3, 8, 5, 7, 6, 4};
    int[] ints = {1, 1};
    new Solution13().nextPermutation(ints);
    System.out.println(Arrays.toString(ints));
  }

  public void nextPermutation(int[] nums) {
    int length = nums.length;
    int i = length - 2;
    // 注意这里必须要是升序
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    // 判断是否存在
    if (i >= 0) {
      // i到j之间都是递减，所以可以这么找到第一个大于nums[i]的元素
      int j = nums.length - 1;
      while (j >= 0 && nums[i] >= nums[j]) {
        j--;
      }
      // 交换i、j位置元素
      swap(nums, i, j);
    }
    // 排序i之后的元素，这一步包含了[3, 2, 1]这样极端的例子，则直接全部反转就可以得到最小的
    revers(nums, i + 1, length - 1);
  }

  // 交换
  public void swap(int[] nums, int i, int j) {
    nums[i] ^= nums[j];
    nums[j] ^= nums[i];
    nums[i] ^= nums[j];
  }

  // 剩余反转
  public void revers(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i++, j--);
    }
  }
}
