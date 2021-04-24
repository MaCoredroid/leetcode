class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] ch=s.toCharArray();
        int temp=0;
        char preSign='+';
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                temp=temp*10+ch[i]-'0';
            }
            if(i==ch.length-1||ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'){
                if(preSign=='+'){
                    stack.push(temp);
                }else if(preSign=='-'){
                    stack.push(temp*(-1));
                }else if(preSign=='*'){
                    stack.push(temp*(stack.pop()));
                }else{
                    stack.push(stack.pop()/temp);
                }
                temp=0;
                preSign=ch[i];
            }
        }
        int ans=0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;

    }
}