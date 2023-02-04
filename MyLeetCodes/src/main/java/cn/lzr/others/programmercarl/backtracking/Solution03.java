package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();



    // 额外两个空字符串是为了更好对应
    static String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        bt(digits,0,0,path);
        return res;
    }


    /**
     * @param digits 输入数字，例如"23"
     * @param k 当k=1时，代表digits数字"2"
     * @param cur 当k=1时，代表digits数字"2"，代表英文"abc"，cur为"abc"下标
     * @param path sb
     * @return
     */
    public void bt(String digits, int k, int cur, StringBuilder path){

        if (path.length() == digits.length()) {
            // 当输入为""时，直接返回空list
            if (digits.length() == 0) return ;
            res.add(path.toString());
            return;
        }
        int charAt = digits.charAt(k) - '0';
        for (int i = cur; i < numString[charAt].length(); i++){
            path.append(numString[charAt].charAt(i));
            bt(digits, k+1, cur, path);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new Solution03().letterCombinations("23");
        for (String s : stringList) {
            System.out.println(s);
        }
    }

}
