class Solution {
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (automaton.sign * automaton.ans);
    }
}

class Automaton{
    public int sign=1;
    public int ans=0;
    private String state= "blank";
    private HashMap<String,String[]> res=new HashMap<>(){{
        put("blank", new String[]{"blank","signed","end","number"});
        put("signed", new String[]{"end","end","end","number"});
        put("number", new String[]{"end","end","end","number"});
        put("end", new String[]{"end","end","end","end"});
    }};

    public void get(char c)
    {
        state= res.get(state)[getCol(c)];
        if(state.equals("signed"))
        {
            if(c=='-')
            {
                sign=-1;
            }
        }
        if(state.equals("number"))
        {
            if(sign==1&&(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&(c-'0')>7)))
            {
                ans=Integer.MAX_VALUE;
                state="end";
            }
            else if(sign==-1&&(ans*(-1)<Integer.MIN_VALUE/10||(ans*(-1)==Integer.MIN_VALUE/10&&(c-'0')>8)))
            {
                ans=Integer.MIN_VALUE*(-1);
                state="end";
            }
            else
            {
                ans=ans*10+(c-'0');
            }
        }
    }

    private int getCol(char c)
    {
        if(c==' ')
        {
            return 0;
        }
        if(c>='0'&&c<='9')
        {
            return 3;
        }
        if(c=='+'||c=='-')
        {
            return 1;
        }
        return 2;
    }



}