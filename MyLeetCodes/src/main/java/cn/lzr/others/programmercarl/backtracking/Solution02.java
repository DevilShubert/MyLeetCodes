package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution02 {
  public static void main(String[] args) {
    //
    System.out.println(new Solution02().combinationSum3(3, 7));
  }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    // 组合总和 III，题号216
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return res;
    }

    public void backTracking(int n, int k, int startIndex, int sum){

        if (sum > n) {
            return;
        }

        if (path.size() == k) {
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }

        // 不剪枝,leetcode都不通过
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backTracking(n, k,i+1, sum);
            sum -= i;
            // 回溯
            path.remove(path.indexOf(i));
        }
    }
}
