package cn.lzr.others.programmercarl.stackAndQueue;

import java.util.Stack;

public class Solution01 {

}

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (!stackOut.empty()) {
            return stackOut.pop();
        }else {
            while (!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }
    }

    public int peek() {
        if (!stackOut.empty()) {
            return stackOut.peek();
        }else {
            while (!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }
    }

    public boolean empty() {
        return  stackOut.isEmpty() && stackIn.empty();
    }
}
