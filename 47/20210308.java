class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ret=new ArrayList<>();
        backTrack(ans,nums,ret);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans,int [] nums,List<Integer> ret){
        if(ret.size()==nums.length){
            ans.add(new ArrayList<>(ret));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=11){
                ret.add(nums[i]);
                int temp=nums[i];
                nums[i]=11;
                backTrack(ans,nums,ret);
                nums[i]=temp;
                ret.remove(ret.size()-1);
            }
            while(i+1<nums.length&&nums[i+1]==nums[i]){
                i++;
            }
        }
    }
}