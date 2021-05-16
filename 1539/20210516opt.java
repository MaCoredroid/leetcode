class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr[0]>k){
            return k;
        }
        int left=0,right=arr.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]-mid-1>=k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        left--;
        return arr[left]+(k-(arr[left]-left-1));
    }
}