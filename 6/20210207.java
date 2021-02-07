class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        List<List<Character>> res=new ArrayList<>();
        boolean direction = true;
        for(int j=0;j<numRows;j++)
        {
            res.add(new ArrayList<>());
        }
        int j=0;
        while(j<s.length())
        {
            for(int i=0;i<numRows-1;i++)
            {
                if(j==s.length())
                {
                    break;
                }
                res.get(i).add(s.charAt(j));
                j++;
            }
            for(int i=numRows-1;i>0;i--)
            {
                if(j==s.length())
                {
                    break;
                }
                res.get(i).add(s.charAt(j));
                j++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(List<Character> line:res)
        {
            for(Character c:line)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}