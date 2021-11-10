class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int cnt=0;
        int leftBar=0,rightBar=0;
        while(left<right){
            if(height[left]<height[right]){
                cnt+=Math.max(0,leftBar-height[left]);
                leftBar=Math.max(leftBar,height[left]);
                left++;
            }else{
                cnt+=Math.max(0,rightBar-height[right]);
                rightBar=Math.max(rightBar,height[right]);
                right--;
            }
        }
        return cnt;
    }
}