package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution19 {
	// 19. 删除链表的倒数第 N 个结点 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		// 首先使用cur结点创造N个距离
		for(int i = 0; i < n; i++) {
			cur = cur.next;
		}
		ListNode dummy = new ListNode();
		// 使用dummy结点指向头结点
		dummy.next = head;
		ListNode post = dummy;
		while(cur != null) {
			cur = cur.next;
			post = post.next;
		}
		ListNode next = post.next.next;
		post.next = next;
		return dummy.next;
	}
}
