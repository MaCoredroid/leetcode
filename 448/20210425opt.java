class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int index=(nums[i]-1)%n;
            nums[index]+=n;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<=n){
                ans.add(i+1);
            }
        }
        return ans;
    }
}