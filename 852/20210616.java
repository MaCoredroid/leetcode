class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if((mid-1>=0&&arr[mid-1]<arr[mid])&&((mid+1)<arr.length&&arr[mid]>arr[mid+1])){
                return mid;
            }
            if((mid-1>=0&&arr[mid-1]<arr[mid])||((mid+1)<arr.length&&arr[mid]<arr[mid+1])){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}