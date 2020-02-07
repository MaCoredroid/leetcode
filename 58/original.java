class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        boolean wordFound=false;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!=' ')
            {
                count++;
                wordFound=true;
            }
            else
            {
                if(wordFound)
                {
                    break;
                }
            }
        }
        return count;
    }
}