class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        while(left<=right)
        {
            if((right-left)*(Math.min(height[right],height[left]))>ans)
            {
                ans=(right-left)*(Math.min(height[right],height[left]));
            }
            if(height[left]<=height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return ans;
    }
}