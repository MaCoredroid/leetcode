class Solution {
    ArrayList<Integer> ans=new ArrayList();
    public TreeNode sortedListToBST(ListNode head) {
        while(head!=null)
        {
            ans.add(head.val);
            head=head.next;
        }
        return helper(0,ans.size()-1);
    }
     public TreeNode helper(int left,int right)
    {
        if(left>right)
        {
            return null;
        }
        int p=(left+right)/2;
        TreeNode root=new TreeNode(ans.get(p));
        root.left=helper(left,p-1);
        root.right=helper(p+1,right);
        return root;
    }
}