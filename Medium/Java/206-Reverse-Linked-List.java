/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }




    constraints:
        max lenght of list; 
        dummy nodes/ sentinel or will they have values 
        space constraints? 
        time complexity? 


    naive: 
        iterate until you reach the end (while head.next != null )then save it 
        repeat.                      then point second last to saved node then save this one 
        repeat.. 

    optimal ; 
    3 pointer solution 

    curr = head 
    next = curr.next
    prev = null 

       prev. curr next
null<-  1    2 -> 3 -> 4 -> 5 
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head; // O(2) space complexity = O(1) space 

        while (curr != null) { // O(n) time 
            ListNode next = curr.next;  
            curr.next = prev; 
            prev = curr;
            curr = next;
        }
        
        return prev; 
    }
}