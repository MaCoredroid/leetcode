class Solution {
    int[] nums;
    Random ran;
    public Solution(int[] nums) {
        this.nums=nums;
        
    }
    
    public int pick(int target) {
        ran=new Random();
        int id=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(ran.nextInt(++count)==0){
                   id=i;
                }
            }
        }
        return id;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */