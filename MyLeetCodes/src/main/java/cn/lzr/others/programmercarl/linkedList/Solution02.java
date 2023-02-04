package cn.lzr.others.programmercarl.linkedList;

public class Solution02 {

    // 链表长度，maxIndex + 1
    int size;
    // 虚拟头结点
    ListNode head;


    public Solution02(){
        // 初始化长度
        size = 0;
        // 定义虚头结点
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index <0 || index > this.size - 1) {
            return -1;
        }

        ListNode cur = head;

        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 如果index大于链表长度则插在末尾
        if (index > size) {
            return ;
        }
        // 小于0则插在链表头部
        if (index < 0) {
            index = 0;
        }
        size++;

        ListNode cur = head;
        ListNode newNode = new ListNode(val);

        for (int i = 0; i < index; i++) {
            // 新增结点
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {return;}
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            // 定位到要删除结点的前一个结点
            pred = pred.next;
        }

        pred.next = pred.next.next;
    }
}
