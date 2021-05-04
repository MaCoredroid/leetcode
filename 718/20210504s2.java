class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ret=0;
        for(int i=0;i<nums2.length;i++){
            ret=Math.max(ret,maxLength(nums1,nums2,i,0,Math.min(nums1.length-i,nums2.length)));
        }
        for(int i=0;i<nums1.length;i++){
            ret=Math.max(ret,maxLength(nums1,nums2,0,i,Math.min(nums1.length,nums2.length-i)));
        }
        return ret;
    }

    private int maxLength(int[] nums1, int[] nums2, int addA,int addB,int len){
        int k=0;
        int ret=0;
        for(int i=0;i<len;i++){
            if(nums1[addA+i]==nums2[addB+i]){
                k++;
                ret=Math.max(k,ret);
            }else{
                k=0;
            }
        }
        return ret;
    }
}