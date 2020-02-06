class Solution {

    ArrayList<String> output=new ArrayList<>();
    int a=0;
    int b=0;
    public void backTrack(String temp)
    {   
        if(a==0&&b==0)
        {
            output.add(temp);
        }
        else
        {
            if(a>0)
            {
                a--;
                backTrack(temp+"(");
                a++;
            }
            if(a<b)
            {
                b--;
                backTrack(temp+")");
                b++;
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        if(n!=0)
        {
            a=n;
            b=n;
            backTrack("");
        }
        return output;
    }
}