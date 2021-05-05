class Solution {
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int t=(nums[i]-1)%nums.length;
            nums[t]+=nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>2*nums.length){
                ans.add(i+1);
            }
        }
        return ans;
    }

    
}