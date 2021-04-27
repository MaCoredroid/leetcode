class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] prefix=new int[nums.length];
        int[] suffix=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i%k==0){
                prefix[i]=nums[i];
            }else{
                prefix[i]=Math.max(prefix[i-1],nums[i]);
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if((i+1)%k==0||i==nums.length-1){
                suffix[i]=nums[i];
            }else{
                suffix[i]=Math.max(suffix[i+1],nums[i]);
            }
        }
        int[] ans=new int[nums.length-k+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=Math.max(suffix[i],prefix[i+k-1]);
        }
        return ans;
    }
}