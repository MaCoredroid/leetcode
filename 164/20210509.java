class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        long exp=1;
        int[] buffer=new int[nums.length];
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while(maxVal>=exp){
            int[] cnt=new int[10];
            for(int i=0;i<nums.length;i++){
                int digits=(nums[i]/(int)exp)%10;
                cnt[digits]++;
            }
            for(int i=1;i<10;i++){
                cnt[i]+=cnt[i-1];
            }
            for(int i=nums.length-1;i>=0;i--){
                int digits=(nums[i]/(int)exp)%10;
                buffer[cnt[digits]-1]=nums[i];
                cnt[digits]--;
            }
            System.arraycopy(buffer,0,nums,0,nums.length);
            exp*=10;
        }
        int ans=0;
        for(int i=1;i<nums.length;i++){
            ans=Math.max(ans,nums[i]-nums[i-1]);
        }
        return ans;
    }
}