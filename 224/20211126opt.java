class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        int res=0,cur=0,sign=1;
        Stack<Integer> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                cur=cur*10+c-'0';
            }else if(c=='+'||c=='-'){
                res+=cur*sign;
                cur=0;
                sign=c=='+'?1:-1;
            }else if(c=='('){
                stack.push(res);
                stack.push(sign);
                res=0;
                sign=1;
            }else if(c==')'){
                res+=cur*sign;
                res*=stack.pop();
                res+=stack.pop();
                cur=0;
            }
        }
        return res+cur*sign;
    }
}