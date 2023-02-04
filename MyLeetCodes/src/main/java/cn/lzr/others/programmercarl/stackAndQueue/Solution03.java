package cn.lzr.others.programmercarl.stackAndQueue;

import java.util.Stack;

public class Solution03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        String abbaca = solution03.removeDuplicates("abbaca");
        System.out.println(abbaca);
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }

            if (s.charAt(i) != stack.peek()) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        String ch = "";
        while (!stack.isEmpty()){
            ch = stack.pop() + ch;
        }

        return ch;
    }
}
