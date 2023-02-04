package cn.lzr.LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {
	// 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

	static List<List<Character>> numbers;
	static List<String> res;
	static StringBuilder sb;

	static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
	}

	public static List<String> letterCombinations(String digits) {
		res = new ArrayList<>();
		if ("".equals(digits)) return res;

		char[] chars = digits.toCharArray();
		numbers = new ArrayList<>();

		sb = new StringBuilder();

		for (int i = 0; i < chars.length; i++) {
			int index = chars[i] - '0';
			char[] curCharsArray = numString[index].toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			Arrays.asList(chars);
			for (Character cur: curCharsArray) {
				list.add(cur);
			}
			numbers.add(list);
		}

		bt(0,numbers.size(), digits.length());
		return res;
	}
	// 回溯时要用到两层for循环

	public static void bt(int curIntOuter, int numbersLen,  int len) {

		if (sb.length() == len) {
			res.add(new String(sb));
			return;
		}

		for (int i = curIntOuter; i < numbersLen; i++) {
			for (int j = 0; j < numbers.get(i).size(); j++) {
				sb.append(numbers.get(i).get(j));
				bt(i+1, numbersLen, len);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
