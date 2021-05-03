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
        if(root==null){
            return "X";
        }
        String left='('+serialize(root.left)+')';
        String right='('+serialize(root.right)+')';
        return left+root.val+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] ptr={0};
        return parse(data,ptr);
    }

    private TreeNode parse(String data, int[] ptr){
        if(data.charAt(ptr[0])=='X'){
            ptr[0]++;
            return null;
        }
        TreeNode root=new TreeNode(-1);
        root.left=parseTree(data,ptr);
        root.val=parseInt(data,ptr);
        root.right=parseTree(data,ptr);
        return root;
    }

    public TreeNode parseTree(String data, int[] ptr){
        ptr[0]++;
        TreeNode subtree=parse(data,ptr);
        ptr[0]++;
        return subtree;
    }

    public int parseInt(String data,int [] ptr){
        int x=0,sign=1;
        if(!Character.isDigit(data.charAt(ptr[0]))){
            sign=-1;
            ptr[0]++;
        }
        while(Character.isDigit(data.charAt(ptr[0]))){
            x*=10;
            x+=data.charAt(ptr[0])-'0';
            ptr[0]++;
        }
        return x*sign;
    }

    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));