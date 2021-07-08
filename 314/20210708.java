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
    Map<Integer,List<Integer>> map=new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(root,0));
        while(queue.size()>0){
            int temp=queue.size();
            for(int i=0;i<temp;i++){
                Node curr=queue.poll();
                helper(curr.node,curr.id);
                if(curr.node!=null){
                    queue.offer(new Node(curr.node.left,curr.id-1));
                    queue.offer(new Node(curr.node.right,curr.id+1));
                }
            }
        }
        List<List<Integer>> ret=new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            ret.add(entry.getValue());
        }
        return ret;
    }
    private static class Node{
        TreeNode node;
        int id;
        public Node(TreeNode node,int id){
            this.node=node;
            this.id=id;
        }
    }
    public void helper(TreeNode root,int id){
        if(root==null){
            return;
        }
        if(!map.containsKey(id)){
            map.put(id,new ArrayList<>());
        }
        map.get(id).add(root.val);
    }
}