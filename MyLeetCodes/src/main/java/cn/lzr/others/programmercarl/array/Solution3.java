package cn.lzr.others.programmercarl.array;

import java.util.Arrays;

public class Solution3 {
    static public int[] sortedSquares(int[] nums){
        int[] sortNum = new int[nums.length];
        int index = nums.length - 1;
        int left = 0, right = nums.length - 1;
        Math.pow(2,3);
        while (index >= 0) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                sortNum[index--] = nums[left] * nums[left];
                left++;
            } else {
                sortNum[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return sortNum;


    }

  public static void main(String[] args) {
      int[] ints = {-4,-1,0,3,10};
    System.out.println(Arrays.toString(Solution3.sortedSquares(ints)));
  }
}
