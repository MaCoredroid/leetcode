class Solution {
    public int findKthPositive(int[] arr, int k) {
        int counter=k;
        int pointer=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==pointer){
                pointer++;
            }else{
                int diff=arr[i]-pointer;
                if(counter<=diff){
                    return pointer+counter-1;
                }
                counter-=diff;
                pointer=arr[i]+1;
            }
        }
        return pointer+counter-1;
    }
}