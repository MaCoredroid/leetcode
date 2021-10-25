/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node t1=p,t2=q;
        while(t1!=t2){
            t1=t1.parent==null?q:t1.parent;
            t2=t2.parent==null?p:t2.parent;
        }
        return t1;
    }
}