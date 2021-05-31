class Solution {
    private int find(int[] arr,int left,int right,int target){
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(arr[mid]>=target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        if(n<=1){
            return 0;
        }
        int leftEnd=0;
        while(leftEnd+1<n&&arr[leftEnd]<=arr[leftEnd+1]){
            leftEnd++;
        }
        if(leftEnd==n-1){
            return 0;
        }
        int rightEnd=n-1;
        while(rightEnd-1>=0&&arr[rightEnd]>=arr[rightEnd-1]){
            rightEnd--;
        }
        if(arr[leftEnd]<=arr[rightEnd]){
            return rightEnd-leftEnd-1;
        }else{
            int res=Math.min(rightEnd,n-leftEnd-1);
            for(int i=0;i<=leftEnd;i++){
                if(rightEnd-i-1<res){
                    int index=find(arr,rightEnd,n-1,arr[i]);
                    res=Math.min(res,index-i-1);
                }
            }
            return res;
        }
    }
}