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
    public int pathSum(TreeNode root, int sum) {
        return helper(root,new ArrayList<>(),sum);
    }

    private int helper(TreeNode root,List<Integer> pres,int sum){
        if(root==null){
            return 0;
        }
        int ans=0;
        for(int i=0;i<pres.size();i++){
            pres.set(i,pres.get(i)+root.val);
            if(pres.get(i)==sum){
                ans++;
            }
        }
        pres.add(root.val);
        if(root.val==sum){
            ans++;
        }
        ans+=helper(root.left,pres,sum);
        ans+=helper(root.right,pres,sum);
        for(int i=0;i<pres.size();i++){
            pres.set(i,pres.get(i)-root.val);
        }
        pres.remove(pres.size()-1);
        return ans;
    }
}