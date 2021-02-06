class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k=(nums1.length+nums2.length)/2;
        if((nums1.length+nums2.length)%2==0)
        {
            return (findKth(nums1, nums2,k)+findKth(nums1, nums2,k+1))/2.0;
        }
        else
        {
            return findKth(nums1, nums2,k+1);
        }
        
    }
    private double findKth(int[] nums1, int[] nums2,int k)
    {
        int index1=0;
        int index2=0;
        while(k>1)
        {
            int step=Math.min(nums1.length-index1,nums2.length-index2);
            step=Math.min(step,k/2);
            if(index1==nums1.length)
            {
                return nums2[k+index2-1];
            }
            if(index2==nums2.length)
            {
                return nums1[k+index1-1];
            }
            if(nums1[index1+step-1]<nums2[index2+step-1])
            {
                index1+=step;
            }
            else
            {
                index2+=step;
            }
            k-=step;
        }
        if(index1==nums1.length)
        {
            return nums2[index2];
        }
        if(index2==nums2.length)
        {
            return nums1[index1];
        }
        int ret=Math.min(nums1[index1],nums2[index2]);
        return ret;
    }
    
}