class Solution {
    public int getSum(int a, int b) {
        int noCarrySum=a^b;
        int carry=(a&b)<<1;
        while(carry!=0){
            int tmp1=noCarrySum;
            int tmp2=carry;
            noCarrySum=tmp1^tmp2;
            carry=(tmp1&tmp2)<<1;
        }
        return noCarrySum;
    }
}