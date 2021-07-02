class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                sb.append(ch);
                cnt++;
            }else if(ch==')'){
                if(cnt>0){
                    sb.append(ch);
                    cnt--;
                }
            }else{
                sb.append(ch);
            }
        }
        if(cnt>0){
            for(int i=sb.length()-1;i>=0;i--){
                if(sb.charAt(i)=='('){
                    sb.deleteCharAt(i);
                    cnt--;
                }
                if(cnt==0){
                    break;
                }
            }
        }
        return sb.toString();
    }
}