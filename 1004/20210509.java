class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,leftCount=0,rightCount=0;
        int ans=0;
        for(int right=0;right<nums.length;right++){
            rightCount+=1-nums[right];
            while(leftCount<rightCount-k){
                leftCount+=1-nums[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}