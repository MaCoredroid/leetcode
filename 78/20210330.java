class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            backTrack(ans,nums,new ArrayList<>(),i,0);
        }
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,int[] nums,List<Integer> res,int size,int start){
        if(size==res.size()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=start;i<nums.length;i++){              
            res.add(nums[i]);
            backTrack(ans,nums,res,size,i+1);
            res.remove(res.size()-1); 
        }
    }
}