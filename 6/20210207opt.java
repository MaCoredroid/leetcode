class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        int step=2*numRows-2;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            if(i==0||i==numRows-1)
            {
                int origin=i;
                while(origin<s.length())
                {
                    sb.append(s.charAt(origin));
                    origin+=step;
                }
            }
            else
            {
                int origin=i;
                while(origin-2*i<s.length())
                {
                    if(origin-2*i>0)
                    {
                        sb.append(s.charAt(origin-2*i));
                    }
                    if(origin<s.length())
                    {
                        sb.append(s.charAt(origin));
                    }
                    origin+=step;
                }
            }
        }
        return sb.toString();
    }
}