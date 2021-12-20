class Solution {
    public int pivotIndex(int[] nums) {
        int[] pre=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        for(int i=0;i<pre.length-1;i++){
            if(pre[i]-pre[0]==pre[pre.length-1]-pre[i+1]){
                return i;
            }
        }
        return -1;
    }
}