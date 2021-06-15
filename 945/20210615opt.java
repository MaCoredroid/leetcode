class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0], min = max;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] < min) min = nums[i];
        }
        max -= min;
        int[] cnts = new int[max + 1];
        for (int num : nums) ++cnts[num - min];
        int ans=0;
        for(int i=0;i<max;i++){
            if(cnts[i]<2){
                continue;
            }
            ans+=cnts[i]-1;
            cnts[i+1]+=cnts[i]-1;
        }
        return ans+cnts[max]*(1+cnts[max]-2)/2;
    }
}