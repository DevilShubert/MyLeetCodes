package cn.lzr.others.programmercarl.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo07 {
  public static void main(String[] args) {
    int[] ints = {1,-2,-5,-4,-3,3,3,5};
    List<List<Integer>> list = fourSum(ints, -11);
    System.out.println(list);
  }




  static public List<List<Integer>> fourSum(int[] nums, int target) {
    // 四数之和
    List<List<Integer>> resList = new ArrayList<>();

    Arrays.sort(nums);

    for (int p1 = 0; p1 < nums.length ; p1++) {

      // trimming
      if (p1 > 0 && nums[p1]==nums[p1-1]) continue;

      for (int p2 = p1 + 1; p2 < nums.length ; p2++){
        // trimming
        if (p2 > p1 + 1 && nums[p2]==nums[p2-1]) continue;

        int left = p2 + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[p1] + nums[p2] + nums[left] + nums[right];
          if (sum > target) {
            right--;
          } else if (sum < target) {
            left++;
          } else {
            resList.add(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right]));

            // trimming
            while (left < right && nums[right] == nums[right-1]) right--;
            while (left < right && nums[left] == nums[left+1]) left++;

            right--;
            left++;
          }
        }
      }
    }

    return resList;
  }

}
