package cn.lzr.others.xiaoHui17.easy;

import java.util.*;

public class Solution01 {
  // 两数之和 https://leetcode-cn.com/problems/two-sum/
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] split = sc.nextLine().split(",");
    int[] ints = new int[split.length];

    for (int i = 0; i < split.length; i++) {
      ints[i] = Integer.valueOf(split[i]);
    }

    int target = sc.nextInt();

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < ints.length; i++) {
      if (!hashMap.isEmpty() && hashMap.containsKey(target - ints[i])) {
        System.out.println(hashMap.get(target - ints[i]) + " " + i);
        break;
      } else {
        hashMap.put(ints[i], i);
      }
    }
  }
}

class Solution01_1 {
  public static void main(String[] args) {
    int[] ints = {-1, 0, 1, 2, -1, -4};
    threeSum(ints);
  }

  // 三数之和
  public static List<List<Integer>> threeSum(int[] nums) {
    ArrayList<List<Integer>> res = new ArrayList<>();
    if (nums.length < 3) return res;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      // 剪枝
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      int temp = 0 - nums[i];

      while (j < k) {
        int cur = nums[j] + nums[k];
        // 分情况移动指针，才能不遗漏所有情况
        if (cur > temp) {
          k--;
        } else if (cur < temp) {
          j++;
        } else {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[j++]);
          list.add(nums[k--]);
          res.add(list);

          // 剪枝
          while (nums[j - 1] == nums[j] && j < k) j++;
          while (nums[k] == nums[k + 1] && j < k) k--;
        }
      }
    }
    return res;
  }
}
