class Solution {
    public int romanToInt(String s) {
        int prevNum=0;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int currentNum=getValue(s.charAt(i));
            if(currentNum>prevNum)
            {
                ans-=prevNum;
            }
            else
            {
                ans+=prevNum;
            }
            prevNum=currentNum;
        }
        ans+=prevNum;
        return ans;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}