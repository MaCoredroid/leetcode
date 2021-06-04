class Solution {
    public int[] subSort(int[] array) {
        int[] ret=new int[]{-1,-1};
        int n=array.length;
        if(n>0){
            int currMin=Integer.MAX_VALUE;
            for(int i=n-1;i>=0;i--){
                if(array[i]>currMin){
                    ret[0]=i;
                }else{
                    currMin=Math.min(currMin,array[i]);
                }
            }
            int currMax=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                if(array[i]<currMax){
                    ret[1]=i;
                }else{
                    currMax=Math.max(currMax,array[i]);
                }
            }
        }
        return ret;  
    }
}