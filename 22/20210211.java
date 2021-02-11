class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        backTrack(new StringBuilder(),ans,0,0,n);
        return ans;

    }

    public void backTrack(StringBuilder sb,List<String> ans,int left, int right, int max)
    {
        if(sb.length()==max*2)
        {
            ans.add(sb.toString());
            return;
        }
        if(left<max)
        {
            sb.append('(');
            backTrack(sb,ans,left+1,right,max);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left)
        {
            sb.append(')');
            backTrack(sb,ans,left,right+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}