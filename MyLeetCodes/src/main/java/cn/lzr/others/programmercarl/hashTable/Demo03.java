package cn.lzr.others.programmercarl.hashTable;

import java.util.HashSet;

public class Demo03 {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = nextNum(n);
        }
        // 对于返回值是boolean类型时，可以使用技巧可以不用if判断而通过return来返回
        return  n == 1;

    }

    public int nextNum(int n) {
        int sum = 0;
        int temp;
        while (n != 0) {
            temp = n % 10;
            sum += Math.pow(temp, 2);
            n /= 10;
        }
        return sum;
    }
}
