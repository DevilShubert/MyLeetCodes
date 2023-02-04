package cn.lzr.others.programmercarl.figure;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Demo01 {
  // 题目：从图中某一节点出发，求到其余各节点的最短路径
  // 输入格式：   5 5      5表示一共有多少个结点， 5表示边数
  //            1 2 3     u=1 v=2 w=3 代表从结点1到结点2的边长度为3
  //            1 3 1     下面会给你任意个边
  //            1 4 3
  //            2 5 1
  //            3 4 1
}

// DFS方法深搜，重点在于如何更新更短的distance
class Condition1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // nodes num
    int nodeNum = sc.nextInt();
    int wNum = sc.nextInt();

    // build tree
    Node1[] node1s = new Node1[nodeNum + 1];

    for (int i = 0; i < wNum; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();

      // init node for element
      if (node1s[u] == null) {
        node1s[u] = new Node1();
      }
      if (node1s[v] == null) {
        node1s[v] = new Node1();
      }

      // count distance each
      node1s[u].neighbor.put(node1s[v], w);
      node1s[v].neighbor.put(node1s[u], w);
    }
    // 防止重复访问首结点
    node1s[1].visited = true;
    dfs(node1s[1]);
    System.out.println("距离如下：");
    for (int i = 2; i <= nodeNum; i++) {
      System.out.println("结点 1 到结点 " + i + "的距离为：" + node1s[i].dis);
    }
  }

  public static void dfs(Node1 begin) {

    // tree recursion
    for (Node1 n : begin.neighbor.keySet()) {

      if (n.visited) {
        // visited but check if there shorter distance
        if (begin.dis + begin.neighbor.get(n) < n.dis) {
          n.dis = begin.dis + begin.neighbor.get(n);
        }
        continue;
      }

      // first update next dis(when not visited)
      n.dis = begin.dis + begin.neighbor.get(n);
      n.visited = true;

      // do recursion
      dfs(n);
    }
  }

  static class Node1 {
    int dis;
    boolean visited;
    // we need  hashMap to store every neighbor node and their dis
    HashMap<Node1, Integer> neighbor;

    public Node1() {
      dis = 0;
      neighbor = new HashMap<>();
    }
  }
}

// BFS方法广搜，重点在于如何更新更短的distance
class Condition2 {
  //        5 5
  //        1 2 3
  //        1 3 1
  //        1 4 3
  //        2 5 1
  //        4 5 2
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // nodes num
    int nodeNum = sc.nextInt();

    // build tree
    Node2[] node2s = new Node2[nodeNum + 1];

    for (int i = 0; i < nodeNum; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();

      if (node2s[u] == null) node2s[u] = new Node2();
      if (node2s[v] == null) node2s[v] = new Node2();

      // store each other
      node2s[u].neighbor.put(node2s[v], w);
      node2s[v].neighbor.put(node2s[u], w);
    }

    // node2s[1].visited = true;
    bfs(node2s[1]);

    System.out.println("距离如下：");
    for (int i = 2; i <= nodeNum; i++) {
      System.out.println("结点 1 到结点 " + i + " 的距离为：" + node2s[i].dis);
    }
  }

  public static void bfs(Node2 node) {
    ArrayDeque<Node2> deque = new ArrayDeque<>();
    node.visited = true;
    deque.addLast(node);
    while (deque.size() != 0) {
      int loop = deque.size();

      // how many node in current layer
      for (int i = 0; i < loop; i++) {
        Node2 first = deque.removeFirst();
        for (Node2 curNeighbor : first.neighbor.keySet()) {

          if (curNeighbor.visited) {
            // visited but check if there shorter distance
            int curDis = first.dis + first.neighbor.get(curNeighbor);
            if (curDis < curNeighbor.dis) {
              curNeighbor.dis = curDis;
            }
            continue;
          }

          curNeighbor.dis = first.dis + first.neighbor.get(curNeighbor);
          curNeighbor.visited = true;

          deque.addLast(curNeighbor);
        }
      }
    }
  }

  static class Node2 {
    int dis;
    boolean visited;
    HashMap<Node2, Integer> neighbor;

    public Node2() {
      dis = 0;
      visited = false;
      neighbor = new HashMap<>();
    }
  }
}
