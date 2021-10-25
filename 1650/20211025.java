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
        Set<Node> set=new HashSet<>();
        while(p!=null){
            set.add(p);
            p=p.parent;
        }
        while(!set.contains(q)){
            q=q.parent;
        }
        return q;
    }
}