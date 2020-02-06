class Solution {
    public int titleToNumber(String s) {
        int base=1;
        int ret=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            char c=s.charAt(i);
            int ans=c-'A'+1;
            ret+=ans*base;
            base*=26;
        }
        return ret;
    }
}