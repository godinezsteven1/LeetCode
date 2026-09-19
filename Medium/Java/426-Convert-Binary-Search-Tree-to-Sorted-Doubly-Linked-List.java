/*
// Definition for a Node.
class Node {
    public int val;
    public Node left; // last 
    public Node right; // next 

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

// dfs in order 

class Solution {

    private Node first;
    private Node last;


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        last.right = first;
        first.left = last;

        return first;
    }

    private void dfs(Node root) {
        if (root != null) {
            dfs(root.left);

            if (last == null) {
                first = root;
            } else {
                last.right = root;
                root.left = last;
            }
            last = root;

            dfs(root.right);
        }
    }
}