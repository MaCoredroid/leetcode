class Solution {
    public int findNthDigit(int n) {
        long base=9,dig=1;
        int num=0;
        while(n>base*dig){
            n-=base*dig;
            num+=base;
            base*=10;
            dig++;
        }
        num+=(n-1)/dig+1;
        int idx=(int)((n-1)%dig)+1;
        while(dig-->idx){
            num/=10;
        }
        return num%10;
    }
}