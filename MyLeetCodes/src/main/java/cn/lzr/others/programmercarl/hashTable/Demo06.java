package cn.lzr.others.programmercarl.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo06 {
      public static void main(String[] args) {
          int[] ints = {-1, 0, 1, 2, -1, -4};
          List<List<Integer>> lists = threeSum(ints);
      }

    // 三数之和
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        // sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length ; i++){
            if (nums[i] > 0) {
                return resList;
            }

            // 不能通过这种方法来对i进行剪枝，因为会有遗漏
            // while (i < nums.length && nums[i]==nums[i+1]) i++;

            // 对于i的剪枝只能后置判断，并且只能continue，不能i++，因为后续代码中的i可能会对结果集有影响
            if (i>0 && nums[i] == nums[i-1]) {continue;}

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    // sum = 0
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // trimming
                    while (left < right && nums[right] == nums[right-1]) right--;
                    while (left < right && nums[left] == nums[left+1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return resList;
    }
}
