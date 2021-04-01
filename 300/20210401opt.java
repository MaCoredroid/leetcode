class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=1;
        dp[1]=nums[0];
        int ans=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>dp[ans]){
                dp[++ans]=nums[i];
            }else{
                int left=1;
                int right=ans-1;
                while(left<=right){
                    int mid=(left+right)/2;
                    if(dp[mid]<nums[i]){    
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
                dp[left]=nums[i];
            }
        }
        return ans;
        
    }
}