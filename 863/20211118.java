/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans=new ArrayList<>();
    TreeNode target;
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans=new ArrayList<>();
        this.target=target;
        this.k=k;
        dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode node){
        if(node==null){
            return -1;
        }else if(node==target){
            subtree_add(node,0);
            return 1;
        }else{
            int L=dfs(node.left),R=dfs(node.right);
            if(L!=-1){
                if(L==k) ans.add(node.val);
                subtree_add(node.right,L+1);
                return L+1;
            }else if(R!=-1){
                if(R==k) ans.add(node.val);
                subtree_add(node.left,R+1);
                return R+1;
            }else{
                return -1;
            }
        }
    }
    
    public void subtree_add(TreeNode node,int d){
        if(node==null) return;
        if(d==k){
            ans.add(node.val);
        }else{
            subtree_add(node.left,d+1);
            subtree_add(node.right,d+1);
        }
    }
    
    
}