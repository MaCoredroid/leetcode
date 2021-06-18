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
    static int MOD=1000000007;
    ArrayList<Long> list=new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long sum=helper(root);
        long max=0;
        long diff=sum;
        for(Long a:list){
            if(Math.abs(sum/2-a)<=diff){
                diff=Math.abs(sum/2-a);
                max=Math.max(max,a*(sum-a));
            }
        }
        return (int)(max%MOD);
    }

    private long helper(TreeNode root){
        if(root==null){
            return 0;
        }
        long ret=root.val+helper(root.left)+helper(root.right);
        list.add(ret);
        return ret;
    }
}