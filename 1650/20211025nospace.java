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
        int count1=0,count2=0;
        Node t1=p,t2=q;
        while(t1!=null){
            count1++;
            t1=t1.parent;
        }
        while(t2!=null){
            count2++;
            t2=t2.parent;
        }
        if(count1<count2){
            Node temp=p;
            p=q;
            q=temp;
        }
        for(int i=0;i<Math.abs(count1-count2);i++){
            p=p.parent;
        }
        while(p!=null&&q!=null&&p!=q){
            p=p.parent;
            q=q.parent;
        }
        return p;
    }
}