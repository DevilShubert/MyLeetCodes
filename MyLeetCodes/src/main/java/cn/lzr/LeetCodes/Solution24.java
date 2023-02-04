package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution24 {
	// 24. 两两交换链表中的节点 https://leetcode.cn/problems/swap-nodes-in-pairs/
	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode right = dummy;
		ListNode left = dummy;
		if (right.next == null || right.next.next == null) {
			return dummy.next;
		}
		do {
			//  移动右指针
			right = right.next.next;
			left.next.next = right.next;
			right.next = left.next;
			left.next = right;
			// 移动左指针
			left = right.next;
			// 注意这里有个小坑，要移动一下right与left
			right = right.next;
		}while (right.next != null && right.next.next != null);

		return dummy.next;
	}
}
