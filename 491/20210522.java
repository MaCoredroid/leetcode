class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,new ArrayList<>(),nums,0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,List<Integer> res,int[] nums ,int pointer){
        if(res.size()>1){
            ans.add(new ArrayList<>(res));
        }
        Set<Integer> set=new HashSet<>();
        for(int i=pointer;i<nums.length;i++){
            if(!set.contains(nums[i])&&(res.size()==0||nums[i]>=res.get(res.size()-1))){
                res.add(nums[i]);
                backTrack(ans,res,nums,i+1);
                res.remove(res.size()-1);
                set.add(nums[i]);
            }
        }
    }
}