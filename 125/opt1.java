class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            
            while(i<j&&!isLetterOrDigit(s.charAt(i)))
            {
                i++;
            }
            while(i<j&&!isLetterOrDigit(s.charAt(j)))
            {
                j--;
                
            }
            if(s.charAt(i)==s.charAt(j)||(s.charAt(i)>='A'&&s.charAt(j)>='A'&&Math.abs(s.charAt(i)-s.charAt(j))==32))
            {
                i++;
                j--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public boolean isLetterOrDigit(Character c) {
        if (('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z')) {
            return true;
        }
        return false;
    }
}