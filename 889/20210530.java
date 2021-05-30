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
    int[]pre,post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre=pre;
        this.post=post;
        return helper(0,0,pre.length);
    }

    public TreeNode helper(int left1,int left2,int N){
        if(N==1){
            return new TreeNode(pre[left1]);
        }
        if(N==0){
            return null;
        }
        TreeNode root=new TreeNode(pre[left1]);
        int L=1;
        for(;L<N;L++){
            if(post[left2+L-1]==pre[left1+1]){
                break;
            }
        }
        root.left=helper(left1+1,left2,L);
        root.right=helper(left1+L+1,left2+L,N-1-L);
        return root;
    }
}