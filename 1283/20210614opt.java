class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=Arrays.stream(nums).max().getAsInt();
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(!check(mid,nums,threshold)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    private boolean check(int res,int[] nums, int threshold){
        int ans=0;
        for(int num:nums){
            ans+=(num-1)/res+1;
        }
        return ans<=threshold;
    }
}