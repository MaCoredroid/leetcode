class Solution {
    HashSet<String> ans=new HashSet<>();
    private void backtrack(String s,int index,int leftCount,int rightCount,int leftRem,int rightRem,StringBuilder sb){
        if(index==s.length()){
            if(leftRem==0&&rightRem==0){
                ans.add(sb.toString());
            }
            return;
        }
        char c=s.charAt(index);
        int len=sb.length();
        if((c=='('&&leftRem>0)||(c==')'&&rightRem>0)){
            backtrack(s,index+1,leftCount,rightCount,leftRem - (c== '(' ? 1 : 0),rightRem - (c == ')' ? 1 : 0),sb);
        }
        sb.append(c);
        if(c!='('&&c!=')'){
            backtrack(s,index+1,leftCount,rightCount,leftRem,rightRem,sb);
        }else if(c=='('){
            backtrack(s,index+1,leftCount+1,rightCount,leftRem,rightRem,sb);
        }else if(rightCount<leftCount){
            backtrack(s,index+1,leftCount,rightCount+1,leftRem,rightRem,sb);
        }
        sb.deleteCharAt(len);
    }
    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                right=(left==0?right+1:right);
                left=(left>0?left-1:left);
            }
        }
        backtrack(s,0,0,0,left,right,new StringBuilder());
        return new ArrayList<String>(ans);
    }
}