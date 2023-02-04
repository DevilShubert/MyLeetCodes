package cn.lzr.others.programmercarl.charString;

public class Solution01 {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 1) return;

        int right = len - 1;
        int left = 0;

        while (left < right) {
            s[left] ^= s[right];
            s[right] ^=s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }
}
