class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res=0,max=0,min=0;
        for(int num:nums){
            max=Math.max(max+num,num);
            res=Math.max(res,max);
            min=Math.min(min+num,num);
            res=Math.max(res,Math.abs(min));
        }
        return res;
    }
}