class Solution {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value=0;
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<values.length;i++)
        {
            while(contain(sb.toString(),symbols[i]))
            {
                sb.delete(0,symbols[i].length());
                value+=values[i];
                if(sb.length()==0)
                {
                    return value;
                }
            }
        }
        return value;
    }

    private boolean contain(String s, String symbol)
    {
        
        int length=symbol.length();
        if(length>s.length())
        {
            return false;
        }
        for(int i=0;i<length;i++)
        {
            if(s.charAt(i)!=symbol.charAt(i))
            {
                return false;
            }
        }
        return true;
        
    }
}