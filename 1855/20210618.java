class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int p=0,ans=0;
        for(int i=0;i<nums1.length;i++){
            if(i>=nums2.length||p>=nums2.length){
                break;
            }
            p=Math.max(p,i);
            if(nums1[i]>nums2[p]){
                continue;
            }
            while(p<nums2.length&&nums1[i]<=nums2[p]){
                p++;
            }
            ans=Math.max(ans,p-i-1);
        }
        return ans;
    }
}