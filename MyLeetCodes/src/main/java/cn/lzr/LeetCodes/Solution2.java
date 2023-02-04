package cn.lzr.LeetCodes;

import dataStructure.ListNode;


public class Solution2 {
	// 两数相加  https://leetcode-cn.com/problems/add-two-numbers/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode dummy = res;
		boolean flag = false;

		while (l1 != null && l2 != null) {
			int val1 = l1.val;
			int val2 = l2.val;
			int sumVal = val1 + val2 + res.val;
			if (sumVal >= 10) {
				sumVal -= 10;
				res.val = sumVal;
				ListNode next = new ListNode();
				next.val = 1;
				res.next = next;
				res = next;
				l1 = l1.next;
				l2 = l2.next;
				flag = true; // 是否进位
			} else {
				res.val = sumVal;
				if (l1.next != null && l2.next != null) {
					ListNode next = new ListNode();
					res.next = next;
					res = next;
				}
				l1 = l1.next;
				l2 = l2.next;
				flag = false; // 是否进位
			}
		}
		while (l1 !=null){
			 if (!flag){
				res.next = l1;
				break;
			 } else {
				 int curSum = l1.val + res.val;
				 if (curSum >= 10) {
					 res.val = (curSum - 10);
					 ListNode next = new ListNode();
					 next.val = 1;
					 res.next = next;
					 res = next;
					 l1 = l1.next;
				 } else{
					 res.val = curSum;
					 if (l1.next != null){
						 ListNode next = new ListNode();
						 res.next = next;
						 res = next;
					 }
					 l1 = l1.next;
				 }
			 }
		}
		while (l2 !=null){
			if (!flag){
				res.next = l2;
				break;
			} else {
				int curSum = l2.val + res.val;
				if (curSum >= 10) {
					res.val = (curSum - 10);
					ListNode next = new ListNode();
					next.val = 1;
					res.next = next;
					res = next;
					l2 = l2.next;
				} else{
					res.val = curSum;
					if (l2.next != null){
						ListNode next = new ListNode();
						res.next = next;
						res = next;
					}
					l2 = l2.next;
				}
			}
		}
		return dummy;
	}
}
