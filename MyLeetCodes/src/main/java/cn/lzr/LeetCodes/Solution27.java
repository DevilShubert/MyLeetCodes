package cn.lzr.LeetCodes;

public class Solution27 {
	public static void main(String[] args) {
		int[] ints = {3,2,2,3};

		new Solution27().removeElement(ints, 3);
	}
	// 27. 移除元素  https://leetcode.cn/problems/remove-element/
	public int removeElement(int[] nums, int val) {
		// 使用快慢指针，只不过遍历的方式有点技巧
		int fast = 0;
		int slow;
		for ( slow = 0; fast < nums.length; fast++) {
			// 通过判断 fast 来决定是否交换元素
			if (nums[fast] != val){
				 int temp = nums[fast];
				 nums[fast] = nums[slow];
				 nums[slow++] = temp;
			}
		}
		return slow;
	}
}
