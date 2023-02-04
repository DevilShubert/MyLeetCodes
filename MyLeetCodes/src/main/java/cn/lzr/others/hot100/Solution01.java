package cn.lzr.others.hot100;

public class Solution01 {
    // No.2016 增量元素之间的最大差值
    // https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/solution/hua-dong-chuang-kou-fa-by-eazure-2aux/
    public int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int j = 1; j < nums.length;j++) {
            for (int i = 0; i < j;i++){
               int temp = nums[j] - nums[i];
               if (temp > max) max = temp;
            }
        }
        if (max <= 0) return -1;
        return max;
    }


    public int maximumDifference2(int[] nums) {
       // 滑动窗口思想，核心就是时刻找到前缀最小值
        int left = 0;
        int max = -1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] <= nums[left]) {
                left = right;
            } else {
                max = Math.max(max, nums[right] - nums[left]);
            }
        }

        return max;

    }



}
