package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution141 {
	// 141. 环形链表  https://leetcode-cn.com/problems/linked-list-cycle/
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;

		ListNode fast, slow;
		fast = head;
		slow = head;
		while(slow.next != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) return true;
		}
		return false;
	}
}
