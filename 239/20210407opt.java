class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int[] prefix=new int[len];
        int[] suffix=new int[len];
        for(int i=0;i<len;i++){
            if(i%k==0){
                prefix[i]=nums[i];
            }else{
                prefix[i]=Math.max(prefix[i-1],nums[i]);
            }
        }
        for(int i=len-1;i>=0;i--){
            if(i==len-1||(i+1)%k==0){
                suffix[i]=nums[i];
            }else{
                suffix[i]=Math.max(suffix[i+1],nums[i]);
            }
        }
        int[] ans=new int[len-k+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=Math.max(suffix[i],prefix[i+k-1]);
        }
        return ans;
    }
}