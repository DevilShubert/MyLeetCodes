package cn.lzr.others.programmercarl.array;

public class Solution4 {
    static public int minSubArrayLen(int target, int[] nums){
        int right = 0;
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(; right < nums.length; right++){
            sum = sum + nums[right];
            while(sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

  public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};

        Solution4.minSubArrayLen(7, arr);
  }
}
