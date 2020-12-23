class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int left=0;
        int right=nums1.length;
        int leftValue=0;
        int rightValue=0;
        while(left<=right)
        {
            int i=(left+right)/2;
            int j=(nums1.length+nums2.length+1)/2-i;
            int left1= i>=1?nums1[i-1]:Integer.MIN_VALUE;
            int left2= j>=1?nums2[j-1]:Integer.MIN_VALUE;
            int right1= i<nums1.length? nums1[i]:Integer.MAX_VALUE;
            int right2= j<nums2.length? nums2[j]:Integer.MAX_VALUE;
            if(left1>right2)
            {
                right=i-1;
            }
            else
            {
                left=i+1;
                leftValue=Math.max(left1,left2);
                rightValue=Math.min(right1,right2);
            }
        }
        return (nums1.length+nums2.length)%2==0?(leftValue+rightValue)/2.0:leftValue;
        
    }
    
}