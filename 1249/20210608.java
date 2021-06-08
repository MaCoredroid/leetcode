class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans=helper(s,'(',')');
        ans=helper(ans.reverse().toString(),')','(');
        return ans.reverse().toString();
    }

    private StringBuilder helper(String s,char c,char h){
        int cnt=0;
        char[] ch=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]==c){
                cnt++;
            }else if(ch[i]==h){
                if(cnt==0){
                    continue;
                }else{
                    cnt--;
                }
            }
            sb.append(ch[i]);
        }
        return sb;
    }
}