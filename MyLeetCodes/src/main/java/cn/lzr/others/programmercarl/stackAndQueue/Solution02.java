package cn.lzr.others.programmercarl.stackAndQueue;

import java.util.Stack;

public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.isValid("{[]}()"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Character cur;
        for (int i = 0; i < s.length(); i++){
            cur = s.charAt(i);
            if (cur == '{' || cur == '(' || cur == '[') {
                stack.push(s.charAt(i));
                continue;
            }


            // 防止"}"这样的输入
            if (stack.isEmpty()) return false;

            switch (cur){
                case '}' : {
                    if (stack.peek()=='{') {
                        stack.pop();
                    } else {
                        stack.push('}');
                    }
                    break;
                }
                case ']' : {
                    if (stack.peek()=='[') {
                        stack.pop();
                    } else {
                        stack.push(']');
                    }
                    break;
                }
                case ')' : {
                    if (stack.peek()=='(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                    break;
                }
            }

        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
