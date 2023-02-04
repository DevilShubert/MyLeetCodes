package cn.lzr.LeetCodes;

public class Solution5 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aacabdkacaa"));
	}
	// 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
	public static String longestPalindrome(String s) {
		// 时间复杂度为O(n^2)
		if (s.length() == 1) return s;
		int length = s.length();
		char[] chars = s.toCharArray();

		int maxLen = Integer.MIN_VALUE;
		String res = null;

		for (int i = 0; i < length; i++) {
			for (int j = length -1; j > i ; j--) {
				if (isReverse(chars, i, j)) {
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						res = new String(chars, i, j - i + 1);
					} else {
						continue;
					}
				}
			}
		}
		return res == null ? s.substring(0,1) : res;
	}

	public static boolean isReverse(char[] chars, int left, int right) {
		while (right >= left){
			if (chars[left] == chars[right]){
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static String longestPalindrome2(String s){
		// 使用二维数组 + 动态规划，但本质上时间复杂度还是O(n^2)
		// dp[i][j] 表示数组s的第i个元素到第j个元素组成的子串是否是回文串
		// 绝妙的递推公式：dp[i][j] = dp[i+1][j-1] ^ (s.charAt(i) == s.charAt(j))
		// 初始化
			// boolean[][] dp = new boolean[10][10];
			// Arrays.fill(dp, true);

		return " ";
	}

}
