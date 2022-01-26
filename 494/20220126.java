class Solution {
    int cnt=0;
    int target=0;
    public int findTargetSumWays(int[] nums, int target) {
        this.target=target;
        backTrack(nums,0,0);
        return cnt;
    }
    
    public void backTrack(int[] nums,int index,int val){
        if(index==nums.length){
            if(val==target){
                cnt++;
            }
            return;
        }
        backTrack(nums,index+1,val+nums[index]);
        backTrack(nums,index+1,val-nums[index]);
    }
}