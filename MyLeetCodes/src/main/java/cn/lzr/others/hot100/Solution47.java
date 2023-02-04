package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution47 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adjArr = new ArrayList<>();
    // init adjArr
    for (int i = 0; i < numCourses; i++) {
      adjArr.add(new ArrayList<Integer>());
    }

    // out degree to 0; 由 1 指向 0 出度到0
    for (int i = 0; i < prerequisites.length; i++) {
      adjArr.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    // flag for dfs
    int[] flag = new int[numCourses];

    // start from 1st node
    for (int i = 0; i < numCourses; i++) {
      if (dfs(flag, i, adjArr) == false) return false;
    }
    return true;
  }

  //
  public boolean dfs(int[] flag, int i, List<List<Integer>> adjArr) {
    if (flag[i] == -1) return true; // last dfs has been visited
    if (flag[i] == 1) return false; // has loop
    // void current dfs
    flag[i] = 1;
    // dfs next The out degree of node
    for (Integer nextI : adjArr.get(i)) {
      if (dfs(flag, nextI, adjArr) == false) return false;
    }
    flag[i] = -1;
    return true;
  }
}
