package cn.lzr.others.hot100;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution04 {

      public static void main(String[] args) {
          Solution04 solution04 = new Solution04();
          System.out.println(solution04.lengthOfLongestSubstring("aab"));
          // pwwkew
          // dvdf
          // aab
      }

    // 无重复字符的最长子串
    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)) {
                deque.addLast(c);
                hashMap.put(c, 1);
                max = Math.max(max, hashMap.size());
            } else {
                while (deque.peek() != c){
                    Character character = deque.removeFirst();
                    hashMap.remove(character);
                }
                Character character = deque.removeFirst();
                deque.addLast(c);
            }
        }
        return max;
    }
}
