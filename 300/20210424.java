class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length+1];
        int len=1;
        dp[len]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[len]<nums[i]){
                dp[++len]=nums[i];
            }else{
                int left=1;
                int right=len-1;
                while(left<=right){
                    int middle=(left+right)/2;
                    if(dp[middle]<nums[i]){
                        left=middle+1;
                    }else{
                        right=middle-1;
                    }
                }
                dp[left]=nums[i];
            }
        }
        return len;
    }
}