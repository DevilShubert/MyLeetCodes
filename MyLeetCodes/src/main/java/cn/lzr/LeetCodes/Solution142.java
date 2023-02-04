package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution142 {
	// 142. 环形链表 II  https://leetcode-cn.com/problems/linked-list-cycle-ii/
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;

			// 成环
			if (slow == fast) {
				ListNode index = head;
				ListNode cur = slow;
				while (index != cur) {
					index = index.next;
					cur = cur.next;
				}
				return index;
			}

		}
		return null;
	}
}
