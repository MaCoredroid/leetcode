class Solution {
    public int integerBreak(int n) {
        if(n<=3){
            return n-1;
        }
        int num1=n/3;
        n=n%3;
        if(n==1){
            num1--;
            int base=1;
            for(int i=0;i<num1;i++){
                base*=3;
            }
            return base*4;
        }else{
            int base=1;
            for(int i=0;i<num1;i++){
                base*=3;
            }
            if(n==0){
                return base;
            }
            return base*n;
        }
    }
}