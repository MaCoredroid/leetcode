class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int ret=0;
        for(int num:nums){
            if(num==1){
                cnt++;
                ret=Math.max(ret,cnt);
            }else{
                cnt=0;
            }
        }
        return ret;
    }
}