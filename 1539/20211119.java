class Solution {
    public int findKthPositive(int[] arr, int k) {
        int prev=0;
        for(int i=0;i<arr.length;i++){
            if(k-(arr[i]-prev-1)<=0){
                return prev+k;
            }
            k-=arr[i]-prev-1;
            prev=arr[i];
        }
        return prev+k;
    }
}