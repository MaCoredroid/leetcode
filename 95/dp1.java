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
    public List<TreeNode> generateTrees(int n) {
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        if(n==0)
        {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> temp=new ArrayList<TreeNode>();
        TreeNode One = new TreeNode(1);
        temp.add(One);
        map.put(1,temp);
        for(int i=2;i<=n;i++)
        {
            map.put(i,addTree(map.get(i-1),i));
        }
        return map.get(n);

    }
    private List<TreeNode> addTree(List<TreeNode> trees,int i)
    {
        List<TreeNode> ans=new ArrayList<>();
        for(TreeNode temp:trees)
        {
            TreeNode top=treeCopy(temp);
            TreeNode toproot= new TreeNode(i);
            toproot.left=top;
            ans.add(toproot);
            TreeNode pre=temp;
            for(TreeNode right=temp.right;right!=null;right=right.right)
            {
                TreeNode curr=treeCopy(temp);
                TreeNode tempright=findNode(right.val,curr);
                TreeNode temppre=findNode(pre.val,curr);
                TreeNode root=new TreeNode(i);
                root.left=tempright;
                temppre.right=root;
                ans.add(curr);
                pre=right;
            }
            TreeNode curr=treeCopy(temp);
            TreeNode tempright=findNode(pre.val,curr);
            TreeNode root=new TreeNode(i);
            tempright.right=root;
            ans.add(curr);

        }
        return ans;
    }
    private TreeNode treeCopy(TreeNode root) {
        if (root == null) 
        {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }
    public TreeNode findNode(int val,TreeNode node){
        if (node.val == val)
        {
            return node;
        }
        if (node.val > val)
        {
            return findNode(val,node.left );
        }
        else
        {
            return findNode(val,node.right );
        }
    }



}