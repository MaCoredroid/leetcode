class Solution {
    public int search(int[] arr, int target) {
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[left]==target){
                return left;
            }
            if(arr[left]==arr[mid]){
                left++;
            }else if(arr[left]>arr[mid]){
                if(target>arr[left]||target<=arr[mid]){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }else{
                if(target<=arr[mid]){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}