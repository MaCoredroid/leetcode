class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length)
        {
            return calculate(nums1,nums2);
        }
        else
        {
            return calculate(nums2,nums1);
        }
        
    }

    private double calculate(int[] nums1, int[] nums2)
    {
        int k=(nums1.length+nums2.length+1)/2;
        int start=0;
        int end=nums1.length;
        int leftmax=0;
        int rightmin=0;
        int len1=nums1.length;
        int len2=nums2.length;
        while(start<=end)
        {
            int i=(start+end)/2;
            int j=k-i;
            int lefti=(i==0?Integer.MIN_VALUE:nums1[i-1]);
            int leftj=(j==0?Integer.MIN_VALUE:nums2[j-1]);
            int righti=(i==len1?Integer.MAX_VALUE:nums1[i]);
            int rightj=(j==len2?Integer.MAX_VALUE:nums2[j]);
            if(lefti<=rightj)
            {
                leftmax=Math.max(lefti,leftj);
                rightmin=Math.min(righti,rightj);
                start=i+1;
            }
            else
            {
                end=i-1;
            }
        }
        return (len1+len2)%2==0?(leftmax+rightmin)/2.0:leftmax;
    }
}