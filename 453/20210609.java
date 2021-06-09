class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
        }
        int ret=0;
        for(int num:nums){
            ret+=(num-min);
        }
        return ret;
    }
}