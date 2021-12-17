class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    
    public void helper(int index,int[] nums,List<Integer> temp,List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        helper(index+1,nums,temp,ans);
        temp.remove(temp.size()-1);
        helper(index+1,nums,temp,ans);
    }
}