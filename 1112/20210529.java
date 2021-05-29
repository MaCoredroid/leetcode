class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper=0;
        for(int i:arr1){
            upper=Math.max(upper,i);
        }
        int[] freq=new int[upper+1];
        for(int i:arr1){
            freq[i]++;
        }
        int[] ans=new int[arr1.length];
        int index=0;
        for(int i:arr2){
            for(int j=0;j<freq[i];j++){
                ans[index++]=i;
            }
            freq[i]=0;
        }
        for(int i=0;i<freq.length;i++){
            for(int j=0;j<freq[i];j++){
                ans[index++]=i;
            }
        }
        return ans;
    }
}