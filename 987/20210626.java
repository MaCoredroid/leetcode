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
    List<Location> locations;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        locations=new ArrayList<>();
        dfs(root,0,0);
        Collections.sort(locations);
        List<List<Integer>> ret=new ArrayList<>();
        ret.add(new ArrayList<>());
        int preX=locations.get(0).x;
        for(Location l:locations){
            if(l.x!=preX){
                preX=l.x;
                ret.add(new ArrayList<>());
            }
            ret.get(ret.size()-1).add(l.val);
        }
        return ret;

    }

    private void dfs(TreeNode root,int index,int height){
        if(root==null){
            return;
        }
        locations.add(new Location(index,height,root.val));
        dfs(root.left,index-1,height+1);
        dfs(root.right,index+1,height+1);
    }
}

class Location implements Comparable<Location>{
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Location that) {
        if (this.x != that.x)
            return Integer.compare(this.x, that.x);
        else if (this.y != that.y)
            return Integer.compare(this.y, that.y);
        else
            return Integer.compare(this.val, that.val);
    }
}