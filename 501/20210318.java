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
    List<Integer> ret=new ArrayList<>();
    int base,count,maxCount;
    public int[] findMode(TreeNode root) {
        while(root!=null){
            if(root.left==null){
                update(root.val);
                root=root.right;
            }else{
                TreeNode rightmost=root.left;
                while(rightmost.right!=null&&rightmost.right!=root){
                    rightmost=rightmost.right;
                }
                if(rightmost.right==root){
                    rightmost.right=null;
                    update(root.val);
                    root=root.right;
                }else{
                    rightmost.right=root;
                    root=root.left;
                }
            }
        }
        int[] ans=new int[ret.size()];
        for(int i=0;i<ret.size();i++){
            ans[i]=ret.get(i);
        }
        return ans;
    }

    private void update(int val){
        if(val!=base){
            base=val;
            count=1;
        }else{
            count++;
        }
        if(count==maxCount){
            ret.add(val);
        }else if(count>maxCount){
            ret=new ArrayList<>();
            ret.add(val);
            maxCount=count;
        }
    }
}