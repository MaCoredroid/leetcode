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
    int count=0;
    public int[] levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,root,0);
        int[] ret=new int[count];
        int pointer=0;
        for(List<Integer> level:res){
            for(Integer value:level){
                ret[pointer++]=value;
            }
        }
        return ret;
    }

    private void dfs(List<List<Integer>> res,TreeNode root,int level){
        if(root==null){
            return;
        }
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        count++;
        dfs(res,root.left,level+1);
        dfs(res,root.right,level+1);
    }
}