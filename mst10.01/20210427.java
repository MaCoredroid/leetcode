class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int pointer=A.length-1;
        int pointer1=m-1;
        int pointer2=n-1;
        while(pointer1>=0||pointer2>=0){
            int num1=(pointer1>=0?A[pointer1]:Integer.MIN_VALUE);
            int num2=(pointer2>=0?B[pointer2]:Integer.MIN_VALUE);
            if(num1<num2){
                A[pointer]=num2;
                pointer2--;
            }else{
                A[pointer]=num1;
                pointer1--;
            }
            pointer--;
        }
        
    }
}