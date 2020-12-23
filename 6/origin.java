class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
        {
            return s;
        }
        List<List<Character>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            res.add(new ArrayList<>());
        }
        boolean flag=true;
        int rows=0;
        for(int i=0;i<s.length();i++)
        {
            if(rows==0&&!flag)
            {
                flag=true;
            }
            if(rows==numRows-1&&flag)
            {
                flag=false;
            }
            res.get(rows).add(s.charAt(i));
            if(flag)
            {
                rows++;
            }
            else
            {
                rows--;
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