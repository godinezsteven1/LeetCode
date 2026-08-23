/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // list same sizes?, memory or other constraints 
        // base case, one or both list are empty or only have 1 member. 
        ListNode answerHead = new ListNode();
        ListNode curr = answerHead;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list1 != null) { 
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return answerHead.next;
    }
}