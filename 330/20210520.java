class Solution {
    public int minPatches(int[] nums, int n) {
        long x=1;
        int len=nums.length,index=0,ans=0;
        while(x<=n){
            if(index<len&&nums[index]<=x){
                x+=nums[index];
                index++;
            }else{
                ans++;
                x*=2;
            }
        }
        return ans;
    }
}