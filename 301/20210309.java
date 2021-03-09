class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else if(s.charAt(i)==')'){
                if(left==0){
                    right++;
                }else{
                    left--;
                }
            }
        }
        Set<String> ret = new HashSet<>();
        dfs(ret,left,right,0,new StringBuilder(),s,0,0);
        return new ArrayList<>(ret);
    }

    private void dfs(Set<String> ret,int left,int right,int start, StringBuilder res,String s,int leftcount, int rightcount){
        if(start==s.length()){
            if(left==0&&right==0){
                ret.add(res.toString());
            }
            return;
        }
        if(s.charAt(start)=='('){
            res.append('(');
            dfs(ret,left,right,start+1,res,s,leftcount+1,rightcount);
            res.deleteCharAt(res.length()-1);
            if(left>0){
                dfs(ret,left-1,right,start+1,res,s,leftcount,rightcount);
            }
        }else if(s.charAt(start)==')'){
            if(leftcount>rightcount){
                res.append(')');
                dfs(ret,left,right,start+1,res,s,leftcount,rightcount+1);
                res.deleteCharAt(res.length()-1);
            }
            if(right>0){
                dfs(ret,left,right-1,start+1,res,s,leftcount,rightcount);
            }
        }else{
            res.append(s.charAt(start));
            dfs(ret,left,right,start+1,res,s,leftcount,rightcount);
            res.deleteCharAt(res.length()-1);
        }
    }


}