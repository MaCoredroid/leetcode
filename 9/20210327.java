class Solution {
    public boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int base=0;
        while(x>base){
            base=base*10+x%10;
            x/=10;
        }
        return base==x||x==base/10;
    }
}