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
    HashMap<String,Integer> map=new HashMap<>();
    List<TreeNode> ans=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return ans;
    }
    
    public String helper(TreeNode root){
        if(root==null) return "";
        String l=helper(root.left);
        String r=helper(root.right);
        String ret="("+l+","+root.val+","+r+")";
        if(map.containsKey(ret)){
            if(map.get(ret)!=1){
                ans.add(root);
                map.put(ret,1);
            }
        }else{
            map.put(ret,0);
        }
        return ret;
    }
}