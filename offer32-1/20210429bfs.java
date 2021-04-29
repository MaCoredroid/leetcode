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
    public int[] levelOrder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp=queue.poll();
            if(tmp!=null){
                ans.add(tmp.val);
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        int[] ret=new int[ans.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
}