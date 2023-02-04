package cn.lzr.others.hot100;

public class Solution53 {
  public int[] productExceptSelf1(int[] nums) {
    int len = nums.length;
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      int mul = 1;
      for (int j = 0; j < len; j++) {
        if (i == j) continue;
        mul = mul * nums[j];
      }
      res[i] = mul;
    }
    return res;
  }

  public int[] productExceptSelf(int[] nums) {
    return nums;
  }
}
