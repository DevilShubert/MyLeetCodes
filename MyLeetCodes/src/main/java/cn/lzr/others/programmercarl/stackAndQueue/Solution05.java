package cn.lzr.others.programmercarl.stackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        int[] ints = {1, 3, -1, 3, 5, 3, 6, 7};
        int[] window = solution05.maxSlidingWindow(ints, 3);
        System.out.println(Arrays.toString(window));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];



        MyQueue2 myQueue = new MyQueue2();

        //先将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }

        int num = 0;
        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            //移除滑动窗口最前面的元素，目的仅仅是等会添加的时候不会重复
            myQueue.pop(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.push(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }

}

class MyQueue2 {
    // 单调队列既保持了队列先进先出的特点，又保持了排序的特点
    // 同时保证这两个要求的方法就是对pop与pull的自定义实现
    Deque<Integer> deque = new LinkedList<>();


    // 在deque的前面弹出
    public void pop(int val) {
        if (!deque.isEmpty() && deque.getFirst() == val){
            // 移除最前面的元素
            deque.poll();
        }
    }

    // 在deque的后面追加
    public void push(int val) {
        while (!deque.isEmpty() && val > deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }

    public int peek(){
        return deque.peek();
    }

}
