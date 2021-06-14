class Solution {
    public int add(int a, int b) {
        int ans=a^b;
        int carry=(a&b)<<1;
        while(carry!=0){
            int temp=ans^carry;
            carry=(ans&carry)<<1;
            ans=temp;
        }
        return ans;

    }
}