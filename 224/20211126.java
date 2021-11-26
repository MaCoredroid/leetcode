class Solution {
    public int calculate(String s) {
        int prevNum=0;
        char prev='+';
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=s.length();i++){
            char c=i==s.length()?'+':s.charAt(i);
            if(c==' '){
                continue;
            }
            if(c=='('){
                int cnt=1;
                int j=i+1;
                while(cnt>0&&j<s.length()){
                    if(s.charAt(j)=='(') cnt++;
                    if(s.charAt(j)==')') cnt--;
                    j++;
                }
                int res=calculate(s.substring(i+1,j-1));
                stack.push(prev=='+'?res:res*(-1));
                i=j-1;
                continue;
            }
            if(Character.isDigit(c)){
                prevNum=prevNum*10+c-'0';
            }else{
                if(prev=='+'){
                    stack.push(prevNum);
                }else if(prev=='-'){
                    stack.push(-1*prevNum);
                }
                prevNum=0;
                prev=c;
            }
        }
        int ans=prevNum;
        while(stack.size()>0){
            ans+=stack.pop();
        }
        return ans;
    }
}