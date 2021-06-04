class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        Random rand=new Random();
        int count=0;
        int ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(rand.nextInt(++count)==0){
                    ret=i;
                }
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */