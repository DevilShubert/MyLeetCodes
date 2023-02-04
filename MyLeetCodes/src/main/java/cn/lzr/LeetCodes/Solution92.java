package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution92 {
	// 反转链表② (https://leetcode-cn.com/problems/reverse-linked-list-ii/)
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		// 先定位 再反转
		ListNode begin = head;
		ListNode lastOne = new ListNode(-1);
		// 左边的前一个
		lastOne.next = begin;

		for (int i = 1; i < left; i++) {
			begin = begin.next;
			lastOne = lastOne.next;
		}
		lastOne.next = null;
		// 右边的后一个
		ListNode newLeft = doReverse(begin, right - left);
		lastOne.next = newLeft;
		if (left == 1) {
			return lastOne.next;
		} else {
			return head;
		}
	}

	public static ListNode doReverse(ListNode head, int loop) {
		if (loop == 0) return head;
		ListNode dummy = null;
		ListNode cur = head;
		ListNode next = null;
		for (int i = 0; i <= loop; i++) {
			next = cur.next;
			cur.next = dummy;
			dummy = cur;
			cur = next;
		}
		head.next = next;
		return dummy;
	}
}
