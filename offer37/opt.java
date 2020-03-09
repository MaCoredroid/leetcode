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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("null,");
            return;
        }
        else {
            sb.append(root.val).append(",");
            serialize(root.left,sb);
            serialize(root.right,sb);
            return;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res=data.split(",");
        LinkedList<String> list=new LinkedList<>(Arrays.asList(res));
        return deserialize(list);
    }
    public TreeNode deserialize(LinkedList<String> list)
    {
        if(list.get(0).equals("null"))
        {
            list.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=deserialize(list);
        root.right=deserialize(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));