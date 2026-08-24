/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> hashMap = new HashMap<>();


    public Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val); 
            hashMap.put(curr, copy);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            Node copy = hashMap.get(curr);
            copy.next = hashMap.get(curr.next);
            copy.random = hashMap.get(curr.random);
            curr = curr.next;
        }
        
        return hashMap.get(head);
    }
}