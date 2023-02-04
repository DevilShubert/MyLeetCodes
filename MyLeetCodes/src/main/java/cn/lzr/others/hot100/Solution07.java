package cn.lzr.others.hot100;

import java.util.Stack;

public class Solution07 {
      public static void main(String[] args) {

    System.out.println(new Solution07().reverse2(1534236469));
      }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0 ) return 0;
        int flag = 0, res = 0;
        if (x < 0) flag = 1;

        Stack<Integer> stack = new Stack<>();
        x = Math.abs(x);
        while (x != 0) {
            stack.push(x % 10);
            x /= 10;
        }

        int size = stack.size();
        while (stack.size() != 0) {
            int peek = (int)stack.peek();
            int pow = size - stack.size();
            if (Integer.MAX_VALUE - res < (peek * Math.pow(10, pow)) ) return 0;
            res = res + (int) (peek * Math.pow(10, pow));
            stack.pop();
        }
        return  flag == 1 ? -1 * res : res;
    }


    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            // 进位组合数字的方法：使用 res = res * 10 + new的方式
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }



}
