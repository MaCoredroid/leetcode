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
    int t=1;
    Map<String, Integer> trees=new HashMap<>();
    Map<Integer, Integer> count=new HashMap<>();
    List<TreeNode> ans=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(root.val).append(helper(root.left)).append(helper(root.right));
        if(!trees.containsKey(sb.toString())){
            trees.put(sb.toString(),t++);
        }
        int index=trees.get(sb.toString());
        count.put(index,count.getOrDefault(index,0)+1);
        if(count.get(index)==2){
            ans.add(root);
        }
        return index;
    }
}