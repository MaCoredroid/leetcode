class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        String res=String.valueOf(x);
        int left=0;
        int right=res.length()-1;
        while(left<=right)
        {
            if(res.charAt(left)!=res.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}