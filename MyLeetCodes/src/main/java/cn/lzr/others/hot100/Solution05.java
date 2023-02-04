package cn.lzr.others.hot100;

public class Solution05 {
  // 最长回文子串
  // https://leetcode-cn.com/problems/longest-palindromic-substring/

  public static void main(String[] args) {
    //
      Solution05 solution05 = new Solution05();
    System.out.println(solution05.longestPalindrome("babad"));
  }

    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";

        if(s.length() == 1) return s;
        char[] chars = s.toCharArray();
        for(int l = 0; l < chars.length; l++) {
            for(int r = l + 1; r < chars.length; r++) {
                if(isReverse(chars, l, r)) {
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        res = new String(chars).substring(l, r + 1);
                    }
                }
            }
        }
        if(max == 0) return s.substring(0,1);
        return res;
    }

    public Boolean isReverse(char[] chars, int l, int r) {
        while( l < r) {
            if(chars[l++] != chars[r--]) return false;

        }
        return true;
    }
}
