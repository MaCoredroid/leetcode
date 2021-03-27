class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[m+n];
        int i=0;
        int j=0;
        int count=0;
        while(count<m+n){
            int val1=i==m?Integer.MAX_VALUE:nums1[i];
            int val2=j==n?Integer.MAX_VALUE:nums2[j];
            if(val1<val2){
                ans[count++]=val1;
                i++;
            }else{
                ans[count++]=val2;
                j++;
            }
        }
        count=0;
        while(count<m+n){
            nums1[count]=ans[count];
            count++;
        }

    }
}