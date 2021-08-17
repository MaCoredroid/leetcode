class Solution {
    public int calculate(String s) {
        char[] ch=s.toCharArray();
        Stack<Integer> stack=new Stack<>();
        char preSign='+';
        int preNum=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                int count=1;
                int j=i+1;
                while(j<ch.length){
                    if(ch[j]=='('){
                        count++;
                    }else if(ch[j]==')'){
                        count--;
                    }
                    if(count==0){
                        break;
                    }
                    j++;
                }
                preNum=calculate(s.substring(i+1,j));
                i=j;
            }else if(ch[i]>='0'&&ch[i]<='9'){
                preNum=preNum*10+ch[i]-'0';
            }else{
                if(preSign=='+'){
                    stack.push(preNum);
                }else if(preSign=='-'){
                    stack.push(preNum*(-1));
                }else if(preSign=='*'){
                    stack.push(stack.pop()*preNum);
                }else{
                    stack.push(stack.pop()/preNum);
                }
                preNum=0;
                preSign=ch[i];
            }
        }
        if(preSign=='+'){
            stack.push(preNum);
        }else if(preSign=='-'){
            stack.push(preNum*(-1));
        }else if(preSign=='*'){
            stack.push(stack.pop()*preNum);
        }else{
            stack.push(stack.pop()/preNum);
        }
        int ret=0;
        for(Integer num:stack){
            ret+=num;
        }
        return ret;
    }
}