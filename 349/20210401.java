class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans=new ArrayList<>();
        int pointer1=0;
        int pointer2=0;
        while(pointer1<nums1.length&&pointer2<nums2.length){
            if(nums1[pointer1]==nums2[pointer2]){
                ans.add(nums1[pointer1]);
                while(pointer1+1<nums1.length&&nums1[pointer1+1]==nums1[pointer1]){
                    pointer1++;
                }
                while(pointer2+1<nums2.length&&nums2[pointer2+1]==nums2[pointer2]){
                    pointer2++;
                }
                pointer1++;
                pointer2++;
            }else if(nums1[pointer1]>nums2[pointer2]){
                pointer2++;
            }else{
                pointer1++;
            }
        }
        int[] ret=new int[ans.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
}