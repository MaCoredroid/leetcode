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
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root==null){
            ans.add(new ArrayList<>());
            return ans;
        }
        Set<TreeNode> res=new HashSet<>();
        res.add(root);
        helper(res,new ArrayList<>());
        return ans;
    }

    private void helper(Set<TreeNode> res,List<Integer> temp){
        if(res.size()==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        Set<TreeNode> copy=new HashSet<>(res);
        for(TreeNode node:res){
            temp.add(node.val);
            copy.remove(node);
            if(node.left!=null){
                copy.add(node.left);
            }
            if(node.right!=null){
                copy.add(node.right);
            }
            helper(copy,temp);
            if(node.left!=null){
                copy.remove(node.left);
            }
            if(node.right!=null){
                copy.remove(node.right);
            }
            copy.add(node);
            temp.remove(temp.size()-1);
        }
    }
}