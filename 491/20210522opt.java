class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        backTrack(ans,new ArrayList<>(),nums,0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,List<Integer> res,int[] nums ,int pointer){
        if(pointer==nums.length){
            if(res.size()>1){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        
        if(res.size()==0||nums[pointer]>=res.get(res.size()-1)){
            res.add(nums[pointer]);
            backTrack(ans,res,nums,pointer+1);
            res.remove(res.size()-1);
        }

        if(res.size()==0||res.get(res.size()-1)!=nums[pointer]){
            backTrack(ans,res,nums,pointer+1);
        }
        
    }
}