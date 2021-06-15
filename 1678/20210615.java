class Solution {
    public String interpret(String command) {
        StringBuilder sb=new StringBuilder();
        char[] ch=command.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='G'){
                sb.append('G');
            }else if(ch[i]=='('){
                if(i+1<ch.length&&ch[i+1]==')'){
                    sb.append('o');
                    i++;
                }else{
                    sb.append("al");
                    i+=3;
                }
            }
        }
        return sb.toString();
    }
}