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
    int ans=0;
    public int diameter(Node root) {
        helper(root);
        return ans-1;
    }
    
    public int helper(Node root){
        if(root==null) return 0;
        int m1=0,m2=0;
        for(Node c:root.children){
            int ret=helper(c);
            if(ret>=m1){
                m2=m1;
                m1=ret;
            }else if(ret>m2){
                m2=ret;
            }
        }
        ans=Math.max(ans,m1+m2+1);
        return Math.max(m1,m2)+1;
    }
}