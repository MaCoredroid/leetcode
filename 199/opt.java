class Solution {
    List<Integer> ans=new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root,0);
        return ans;
    }
    private void helper(TreeNode root,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(depth==ans.size())
        {
            ans.add(root.val);
        }
        helper(root.right,depth+1);
        helper(root.left,depth+1);
    }
}