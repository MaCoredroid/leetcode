class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while(n>count){
            n-=count;
            digit++;
            start*=10;
            count=start*digit*9;
        }
        long num=start+(n-1)/digit;
        return Long.toString(num).charAt((n-1)%digit)-'0';
    }
}