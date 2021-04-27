class Solution {
    public int calculate(String s) {
        Deque<Integer> stack=new LinkedList<>();
        stack.push(1);
        int sign=1;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='+'){
                sign=stack.peek();
            }else if(cur=='-'){
                sign=-stack.peek();
            }else if(cur=='('){
                stack.push(sign);
            }else if(cur==')'){
                stack.pop();
            }else if(cur>='0'&&cur<='9'){
                int temp=0;
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    temp=temp*10+s.charAt(i)-'0';
                    i++;
                }
                ans+=sign*temp;
                i--;
            }
        }
        return ans;
    }
}