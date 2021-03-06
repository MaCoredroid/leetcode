class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int prevLeft=0;
        int ans=0;
        int prevRight=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>prevLeft){
                    prevLeft=height[left];
                }else{
                    ans+=prevLeft-height[left];
                }
                left++;
            }else{
                if(height[right]>prevRight){
                    prevRight=height[right];
                }else{
                    ans+=prevRight-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}