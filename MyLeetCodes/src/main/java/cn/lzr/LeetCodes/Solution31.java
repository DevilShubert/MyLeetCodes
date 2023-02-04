package cn.lzr.LeetCodes;

public class Solution31 {
	// 31. 下一个排列 https://leetcode.cn/problems/next-permutation/
	public static void main(String[] args) {
		int[] ints = {1,3,2};
		new Solution31().nextPermutation(ints);
	}

	public void nextPermutation(int[] nums) {
		// 这道题优点类似于「删去k个数字后的最小值」那道题，但是还要复杂一点
		int length = nums.length;
		int i = length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		// 判断是否存在
		if (i >= 0) {
			// i+1到j之间都是递减，所以可以这么找到第一个大于nums[i]的元素
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			// 交换i、j位置元素，如果没有则相当于不交换
			swap(nums, i, j);
		}
		// 排序i之后的元素，这一步包含了[3, 2, 1]这样极端的例子，则直接全部反转就可以得到最小的
		revers(nums, i + 1, length - 1);
	}

	// 交换
	public void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	// 剩余反转
	public void revers(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}
}
