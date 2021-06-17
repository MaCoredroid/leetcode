class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int p=arr.length-1;
        int j=p;
        while(j-1>=0&&arr[j-1]<=arr[j]){
            j--;
        }
        if(j==0){
            return arr;
        }
        int left=j;
        int right=p;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]>=arr[j-1]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        int k=left-1;
        while(k-1>=0&&arr[k-1]==arr[k]){
            k--;
        }
        swap(arr,j-1,k);
        return arr;
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}