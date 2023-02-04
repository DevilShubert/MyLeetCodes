package cn.lzr.LeetCodes;

public class Solution11 {
	//  盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
	public int maxArea1(int[] height) {
		// 方法一：二维遍历时间复杂度为O(n^2)，会超时
		int res = Integer.MIN_VALUE;
		int len = height.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				res = Math.max((j - i) * Math.min(height[i], height[j]), res);
			}
		}
		return res;
	}

	public int maxArea2(int[] height) {
		// 方法二：使用双指针时间复杂度为O(n)
		int res = 0;
		int left = 0;
		int right = height.length - 1;
		int temp;
		while (left < right) {
			temp = (right - left) * Math.min(height[left], height[right]);
			res = Math.max(res, temp);
			// 根据短板效应，决定于桶高度的是较小的那个木板，所以移动它即可
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return res;
	}

}
