class Solution {

    private int happy(int n)
    {
        int ans=0;
        while(n>0)
        {
            int temp=n%10;
            ans+=temp*temp;
            n/=10;
        }
        return ans;
    }
    public boolean isHappy(int n) {
        int fast=n; 
        int slow=n;
        do
        {
            slow=happy(slow);
            fast=happy(fast);
            fast=happy(fast);
        }while(fast!=slow);
        return slow==1;
    }
}