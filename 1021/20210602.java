class Solution {
    public String removeOuterParentheses(String s) {
        char[] ch=s.toCharArray();
        int left=0;
        int lCnt=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                lCnt++;
            }else{
                lCnt--;
            }
            if(lCnt==0){
                sb.append(s.substring(left+1,i));
                left=i+1;
            }
        }
        return sb.toString();
    }
}