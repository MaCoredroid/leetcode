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
    List<TreeNode> path;
    Map<TreeNode, LeafResult> map;
    public int findClosestLeaf(TreeNode root, int k) {
        path=new ArrayList<>();
        map=new HashMap<>();
        dfs(root,k);
        int dis=path.size()-1;
        int ret=Integer.MAX_VALUE;
        TreeNode leaf=null;
        for(TreeNode node:path){
            LeafResult lr=closestLeaf(node);
            if (lr.dist + dis < ret) {
                ret = lr.dist + dis;
                leaf = lr.node;
            }
            dis--;
        }
        return leaf.val;
    }
    
    
    public boolean dfs(TreeNode node,int k){
        if(node==null) return false;
        else if(node.val==k){
            path.add(node);
            return true;
        }else{
            path.add(node);
            if(dfs(node.left,k)) return true;
            if(dfs(node.right,k)) return true;
            path.remove(path.size()-1);
            return false;
        }
    }
    
    public LeafResult closestLeaf(TreeNode root){
        if(root==null){
            return new LeafResult(null,Integer.MAX_VALUE);
        }else if(root.left==null&&root.right==null){
            return new LeafResult(root,0);
        }else if(map.containsKey(root)){
            return map.get(root);
        }else{
            LeafResult r1=closestLeaf(root.left);
            LeafResult r2=closestLeaf(root.right);
            LeafResult ans=new LeafResult(r1.dist<r2.dist?r1.node:r2.node,Math.min(r1.dist, r2.dist)+1);
            map.put(root,ans);
            return ans;
        }
    }
}

class LeafResult{
    TreeNode node;
    int dist;
    LeafResult(TreeNode n,int d){
        this.node=n;
        this.dist=d;
    }
}