class Solution {
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
            int i=0,j=rightEnd;
            while(i<=leftEnd&&j<=n-1){
                if(arr[i]<=arr[j]){
                    res=Math.min(res,j-i-1);
                    i++;
                }else{
                    j++;
                }
            }
            return res;
        }
    }
}