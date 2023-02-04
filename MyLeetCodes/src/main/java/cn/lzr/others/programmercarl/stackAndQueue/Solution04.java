package cn.lzr.others.programmercarl.stackAndQueue;

import java.util.Stack;

public class Solution04 {
  public static void main(String[] args) {
    //
      Solution04 solution04 = new Solution04();
      String[] strings = {"2", "1", "+", "3", "*"};
    System.out.println(solution04.evalRPN(strings));
  }

    public int evalRPN(String[] tokens) {
        String temp;
        Stack<Integer> stack = new Stack<>();
        int left, right;
        for (int i = 0; i < tokens.length; i++) {
            temp = tokens[i];
            if (temp.equals("+")  || temp.equals("-") || temp.equals("*") || temp.equals("/")){
                switch (temp){
                    case "+" :{
                        right = stack.pop();
                        left = stack.pop();
                        stack.push(left + right);
                        continue;
                    }
                    case "-" :{
                        right = stack.pop();
                        left = stack.pop();
                        stack.push(left - right);
                        continue;
                    }
                    case "*" :{
                        right = stack.pop();
                        left = stack.pop();
                        stack.push(left * right);
                        continue;
                    }
                    case "/" :{
                        right = stack.pop();
                        left = stack.pop();
                        stack.push(left / right);
                        continue;
                    }
                }
            }
            stack.push(Integer.valueOf(temp));
        }
        return stack.pop();
    }
}
