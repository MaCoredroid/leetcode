class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i=1;i<=nums.length;i++){
            backTrack(ans,i,nums,new ArrayList<>(),0);
        }
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,int len,int[] nums,List<Integer> res,int start){
        if(res.size()==len){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=start;i<nums.length;i++){
            res.add(nums[i]);
            backTrack(ans,len,nums,res,i+1);
            res.remove(res.size()-1);
        }
    }

    
   
}