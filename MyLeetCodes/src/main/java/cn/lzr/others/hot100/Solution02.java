package cn.lzr.others.hot100;

public class Solution02 {
    public static void main(String[] args){
        StringBuilder s = new StringBuilder("123/123123");
        System.out.println(s.insert(2, "s"));

        System.out.println();
    }


    // 最优除法
    // https://leetcode-cn.com/problems/optimal-division/
    // 这道题有点类似数学推导，只要当n>2时，需要加的括号固定，再使用StringBuilder构造即可
    // 真实笔试时要有这种敏锐度猜到正确答案
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        for (int i = 1; i < n; i++) {
            stringBuilder.append("/");
            stringBuilder.append(nums[i]);
        }
        if (n > 2) {
            // insert after offset place
            stringBuilder.insert(stringBuilder.indexOf("/") + 1,'(');
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
