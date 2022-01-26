class Solution {
    int missing(int idx,int[] nums){
        return nums[idx]-nums[0]-idx;
    }
    public int missingElement(int[] nums, int k) {
        int n=nums.length;
        if(k>missing(n-1,nums)) return nums[n-1]+k-missing(n-1,nums);
        int left=0,right=n-1,p=0;
        while(left<=right){
            p=left+((right-left)>>1);
            if(missing(p,nums)<k) left=p+1;
            else right=p-1;
        }
        return nums[left-1]+k-missing(left-1,nums);
    }
}