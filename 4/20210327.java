class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left=0;
        int right=m;
        int ans1=0;
        int ans2=0;
        while(left<=right){
            int i=left+((right-left)>>1);
            int j=((m+n+1)>>1)-i;
            int im1=(i==0?Integer.MIN_VALUE:nums1[i-1]);
            int im=(i==m?Integer.MAX_VALUE:nums1[i]);
            int jm1=(j==0?Integer.MIN_VALUE:nums2[j-1]);
            int jm=(j==n?Integer.MAX_VALUE:nums2[j]);
            if(im1<=jm){
                ans1=Math.max(im1,jm1);
                ans2=Math.min(im,jm);
                left=i+1;
            }else{
                right=i-1;
            }
        }
        return (m+n)%2==0?(ans1+ans2)/2.0:ans1;
    }
}