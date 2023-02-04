package cn.lzr.others.hot100;

public class Solution25 {

  public static void main(String[] args) {
    Solution25 solution25 = new Solution25();
    solution25.sortColors(new int[] {2, 0, 2, 1, 1, 0});
  }

  public void sortColors(int[] nums) {
    int redP = 0;
    // 把所有红色放在最前面
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0 && redP == i) {
        redP++;
        continue;
      }
      if (nums[i] == 0) {
        nums[redP] ^= nums[i];
        nums[i] ^= nums[redP];
        nums[redP] ^= nums[i];
        redP++;
      }
    }
    int whiteP = redP;
    for (int i = whiteP; i < nums.length; i++) {
      if (nums[i] == 1 && whiteP == i) {
        whiteP++;
        continue;
      }
      if (nums[i] == 1) {
        nums[whiteP] ^= nums[i];
        nums[i] ^= nums[whiteP];
        nums[whiteP] ^= nums[i];
        whiteP++;
      }
    }
  }

  public void sortColors2(int[] nums) {}
}
