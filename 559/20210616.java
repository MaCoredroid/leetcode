/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int ret=0;
    public int maxDepth(Node root) {
        helper(root,1);
        return ret;
    }

    private void helper(Node root,int depth){
        if(root==null){
            ret=Math.max(ret,depth-1);
            return;
        }
        if(root.children.size()==0){
            ret=Math.max(ret,depth);
            return;
        }
        for(Node node:root.children){
            helper(node,depth+1);
        }
    }
}