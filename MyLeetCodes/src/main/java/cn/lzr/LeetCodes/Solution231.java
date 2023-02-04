package cn.lzr.LeetCodes;

public class Solution231 {
	// 2 的幂 https://leetcode-cn.com/problems/power-of-two/
	public boolean isPowerOfTwo(int n) {
		if(n<=0) return false;
		return  (n & n-1)  == 0 ? true: false ;
	}
}
