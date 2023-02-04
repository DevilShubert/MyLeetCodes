package cn.lzr.LeetCodes;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class Solution3 {
	// 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

	public static void main(String[] args) {
		// 使用队列本质上还是滑动窗口
		System.out.println(lengthOfLongestSubstring("pwwkew"));

	}

	public static int lengthOfLongestSubstring(String s) {
		char[] array = s.toCharArray();
		if (array.length == 0) return 0;

		ArrayDeque<Character> deque = new ArrayDeque<>();
		HashSet<Character> set = new HashSet<>();

		// 初始化
		deque.addLast(array[0]);
		set.add(array[0]);
		int maxLen = 1;

		for (int i = 1; i < array.length; i++) {
			char curChar = array[i];
			if (!set.contains(curChar)) {
				deque.addLast(curChar);
				set.add(curChar);
				maxLen = deque.size() >= maxLen ? deque.size() : maxLen;
			} else {
				maxLen = deque.size() >= maxLen ? deque.size() : maxLen;
				// 定位到重复的那个字符
				while (deque.peekFirst() != curChar) {
					Character pollFirst = deque.pollFirst();
					set.remove(pollFirst);
				}
				// 删除重复的那个字符，注意有可能导致deque删到没有
				while (deque.size() > 0 && deque.peekFirst() == curChar){
					deque.pollFirst();
				}
				// set.remove(curChar);
				deque.addLast(curChar);
			}
		}
		return maxLen;
	}

	public static int lengthOfLongestSubstring2(String s) {
		// 高级版滑动窗口：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
		if (s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int left = 0;
		for(int i = 0; i < s.length(); i ++){
			if(map.containsKey(s.charAt(i))){
				// 如果包含则更新当前left指针，这里之所以要用max是为了处理"abba"这种情况，具体见题解
				left = Math.max(left,map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i),i);
			max = Math.max(max,i-left+1);
		}
		return max;
	}
}
