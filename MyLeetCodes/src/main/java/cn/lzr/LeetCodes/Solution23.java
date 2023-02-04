package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution23 {
	// 23. 合并K个升序链表 https://leetcode.cn/problems/merge-k-sorted-lists/
	// 直接套用合并两个升序链表
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		if (lists.length == 1) return lists[0];

		ListNode cur = lists[0];
		for (int i = 1; i < lists.length; i++) {
			cur = mergeTwoLists(cur, lists[i]);
		}
		return cur;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// 核心思路：两节点比较，最后的关系永远是结点值大的指向结点值小的
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		} else if (list1.val <= list2.val) {
			list1.next =  mergeTwoLists(list1.next, list2);
			return list1;
		} else  {
			list2.next =  mergeTwoLists(list1, list2.next);
			return list2;
		}
	}
}
