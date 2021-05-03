/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private void rserialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("None,");
            return;
        }
        sb.append(root.val).append(",");
        rserialize(root.left,sb);
        rserialize(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        rserialize(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> ans=new LinkedList<>(Arrays.asList(data.split(",")));
        return rdeserialize(ans);
    }

    private TreeNode rdeserialize(List<String> ans){
        if(ans.get(0).equals("None")){
            ans.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(ans.get(0)));
        ans.remove(0);
        root.left=rdeserialize(ans);
        root.right=rdeserialize(ans);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));