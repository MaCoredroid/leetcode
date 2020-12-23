class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            int k=0;

            while(true)
            {
                if(i+(2*numRows-2)*k<s.length())
                {
                    sb.append(s.charAt(i+(2*numRows-2)*k));
                }
                else
                {
                    break;
                }
                k++;
                if(i!=0&&i!=numRows-1)
                {
                    if(-i+(2*numRows-2)*k<s.length())
                    {
                        sb.append(s.charAt(-i+(2*numRows-2)*k));
                    }
                    else
                    {
                        break;
                    }
                }

            }
            
             
        }
        return sb.toString();
    }
}