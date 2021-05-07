class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    private void backTrack(List<String> ans, StringBuilder sb,int left,int right,int n){
        if(left==right&&left==n){
            ans.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            backTrack(ans,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right+1<=left){
            sb.append(')');
            backTrack(ans,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}