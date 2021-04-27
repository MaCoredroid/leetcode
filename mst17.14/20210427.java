class Solution {
    public int[] smallestK(int[] arr, int k) {
        helper(arr,k,0,arr.length-1);
        return Arrays.copyOfRange(arr,0,k);
        
    }

    private void helper(int[] arr,int k,int p,int q){
        if(p>=q){
            return;
        }
        int pivot=arr[p];
        int left=p;
        int right=q;
        while(left<right){
            while(left<right&&arr[right]>=pivot){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<=pivot){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=pivot;
        if(left==k-1){
            return;
        }else if(left<k){
            helper(arr,k,left+1,q);
        }else{
            helper(arr,k,p,left-1);
        }
    }
}