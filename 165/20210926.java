class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1=version1.split("\\.");
        String[] nums2=version2.split("\\.");
        int p1=0,p2=0;
        while(p1<nums1.length&&p2<nums2.length){
            int num1=parseString(nums1[p1++]);
            int num2=parseString(nums2[p2++]);
            if(num1!=num2){
                return (num1-num2<0)?-1:1;
            }
        }
        while(p1<nums1.length){
            int num1=parseString(nums1[p1++]);
            if(num1>0){
                return 1;
            }
        }
        while(p2<nums2.length){
            int num2=parseString(nums2[p2++]);
            if(num2>0){
                return -1;
            }
        }
        return 0;
    }
    
    public int parseString(String num){
        int ret=0;
        for(char c:num.toCharArray()){
            ret=ret*10+(c-'0');
        }
        return ret;
    }
}