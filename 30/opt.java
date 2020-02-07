class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> output = new ArrayList<>();
        if (words == null || words.length == 0) {
            return output;
        }
        int wordLength=words[0].length();
        int totalLength=wordLength*words.length;
        int slen=s.length();
        int[] flagArray=new int[wordLength];
        for(int i=0;i<wordLength;i++)
        {
            int flag=0;
            for(String word:words)
            {
                flag+=word.charAt(i);
            }
            flagArray[i]=flag;
        }
        BitSet bs = new BitSet(words.length);
        for(int i=0;i+totalLength<=slen;i++)
        {
            int j=0;
            for(;j<wordLength;j++)
            {
                int sumFlag=0;
                for(int k=0;k<words.length;k++)
                {
                    sumFlag+=s.charAt(i+j+k*wordLength);
                }
                if(sumFlag!=flagArray[j])
                {
                    break;
                }
            }
            if(j==wordLength)
            {
                bs.clear();
                for(int k=0;k<words.length;k++)
                {
                    String temp=s.substring(i+k*wordLength,i+(k+1)*wordLength);
                    int n=0;
                    for(;n<words.length;n++)
                    {
                        if(words[n].equals(temp)&&!bs.get(n))
                        {
                            bs.set(n);
                            break;
                        }
                    }
                    if(n==words.length)
                    {
                        break;
                    }
                }
                if (bs.cardinality() == words.length) 
                {
                    output.add(i);
                }
            }
        }
        return output;
    }
}