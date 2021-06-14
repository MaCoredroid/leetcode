/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public Node findRoot(List<Node> tree) {
        int ans=0;
        for(Node node:tree){
            ans^=node.val;
            for(Node child:node.children){
                ans^=child.val;
            }
        }
        for(Node node:tree){
            if(ans==node.val){
                return node;
            }
        }
        return null;
    }
}