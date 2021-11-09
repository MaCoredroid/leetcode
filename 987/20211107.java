/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeMap<Integer,List<Node>> map=new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);
        List<List<Integer>> ans=new ArrayList<>();
        for(Map.Entry<Integer,List<Node>> e:map.entrySet()){
            List<Node> res=e.getValue();
            Collections.sort(res,(o1,o2)->(o1.y==o2.y?o1.val-o2.val:o1.y-o2.y));
            List<Integer> ret=new ArrayList<>();
            for(Node n:res){
                ret.add(n.val);
            }
            ans.add(ret);
        }
        return ans;
    }
    
    public void helper(TreeNode root,int x,int y){
        if(root==null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x,new ArrayList<>());
        }
        map.get(x).add(new Node(y,root.val));
        helper(root.left,x-1,y+1);
        helper(root.right,x+1,y+1);
    }
    
    
}

class Node{
    int y;
    int val;
    public Node(int y,int val){
        this.y=y;
        this.val=val;
    }
}