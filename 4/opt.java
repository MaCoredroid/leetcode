class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums2.length+nums1.length)%2==1)
        {
            return findKthElement(nums1,nums2,(nums2.length+nums1.length)/2+1);
        }
        else
        {
            return (findKthElement(nums1,nums2,(nums2.length+nums1.length)/2)+findKthElement(nums1,nums2,(nums2.length+nums1.length)/2+1))/2.0;
        }
        
    }
    public int findKthElement(int[] nums1,int[]nums2,int k)
    {
        int length1=nums1.length;
        int length2=nums2.length;
        int index1=0;
        int index2=0;
        while(true)
        {
            if(index1==length1)
            {
                return nums2[index2+k-1];
            }
            if(index2==length2)
            {
                return nums1[index1+k-1];
            }
            if(k==1)
            {
                return nums1[index1]<nums2[index2]?nums1[index1]:nums2[index2];
            }
            int half =k/2;
            int newindex1=Math.min(index1+half,length1)-1;
            int newindex2=Math.min(index2+half,length2)-1;
            if(nums1[newindex1]<=nums2[newindex2])
            {
                k-=newindex1-index1+1;
                index1=newindex1+1;
            }
            else
            {
                k-=newindex2-index2+1;
                index2=newindex2+1;
            }
        }
    }
}