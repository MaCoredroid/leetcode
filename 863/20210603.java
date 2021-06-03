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
    int num=0;
    int limit=0;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.num=target.val;
        this.limit=k;
        helper(root,-1);
        return ans;
    }

    private int helper(TreeNode root, int dis){
        if(root==null){
            return -1;
        }
        if(dis==0){
            ans.add(root.val);
            return -1;
        }
        if(dis==-1){
            if(root.val==num){
                if(limit==0){
                    ans.add(root.val);
                    return -1;
                }
                int ans1=helper(root.left,limit-1);
                int ans2=helper(root.right,limit-1);
                return limit-1;
            }
            int ans1=helper(root.left,-1);
            int ans2=helper(root.right,-1);
            if(ans1==-1&&ans2==-1){
                return -1;
            }else{
                if(ans1==0||ans2==0){
                    ans.add(root.val);
                    return -1;
                }
                if(ans1==-1){
                    helper(root.left,ans2-1);
                    return ans2-1;
                }
                if(ans2==-1){
                    helper(root.right,ans1-1);
                    return ans1-1;
                }
            }
        }else{
            helper(root.left,dis-1);
            helper(root.right,dis-1);
            return -1;
        }
        return -1;
    }
}