class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        char[] ch=s.toCharArray();
        int temp=0;
        char presign='+';
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='0'&&ch[i]<='9'){
                temp=temp*10+ch[i]-'0';
            }else if(ch[i]=='('){
                int j=i;
                i++;
                int cnt=1;
                while(i<ch.length&&cnt>0){
                    if(ch[i]=='('){
                        cnt++;
                    }
                    if(ch[i]==')'){
                        cnt--;
                        if(cnt==0){
                            break;
                        }
                    }
                    i++;
                }
                temp=calculate(s.substring(j+1,i));
                i++;
            }
            if(i>=ch.length-1||ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'){
                if(presign=='+'){
                    stack.push(temp);
                }else if(presign=='-'){
                    stack.push(-temp);
                }else if(presign=='*'){
                    stack.push(temp*stack.pop());
                }else{
                    stack.push(stack.pop()/temp);
                }
                if(i<ch.length){
                    presign=ch[i];
                }
                temp=0;
            }
        }
        int ret=0;
        while(!stack.isEmpty()){
            ret+=stack.pop();
        }
        return ret;
    }
}