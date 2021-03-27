class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int base=0;
        int curr=x;
        while(curr>0){
            base*=10;
            base+=curr%10;
            curr/=10;
        }
        return base==x;
    }
}