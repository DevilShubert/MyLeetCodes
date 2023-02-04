package cn.lzr.others.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution01 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1, path);
        return res;
    }

    public void backTracking(int n, int k, int startIndex, List<Integer> path){

        // end condition
        if (path.size() == k){
            // 新建一个对象的原因是因为之后path会改变，如果直接传入path地址则也会更着改变
            res.add(new ArrayList<>(path));
            return;
        }

        // 横向for循环
        // 剪枝操作： for(int i = startIndex; i <= n - (k - path.size()) + 1; i++)
        // n：总数；path.size()：已经选择的数目；k - path.size()：还要选择的数目
        for(int i = startIndex; i <= n; i++) {
            path.add(i);

            backTracking(n, k, i+1, path);

            // 回溯过程，需要将path中已有的减去
            path.remove(path.indexOf(i));
        }
    }

}
