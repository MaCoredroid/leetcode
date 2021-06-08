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
    TreeNode target=null;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        find(root,x);
        int l=count(target.left);
        int r=count(target.right);
        if(l>n/2||r>n/2||(l+r)<n/2){
            return true;
        }
        return false;
    }

    private void find(TreeNode root,int val){
        if(root==null){
            return;
        }
        if(root.val==val){
            target=root;
            return;
        }
        find(root.left,val);
        find(root.right,val);
    }

    private int count(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans=1;
        ans+=count(root.left);
        ans+=count(root.right);
        return ans;
    }
}