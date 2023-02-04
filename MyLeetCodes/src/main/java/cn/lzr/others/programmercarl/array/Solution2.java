package cn.lzr.others.programmercarl.array;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int fast = 0;
        int slow;
        for (slow = 0; fast<nums.length; fast++){
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
