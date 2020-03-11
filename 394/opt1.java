import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack=new Stack<>();
        Stack<Integer> integerStack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[')
            {
                stringStack.push(sb.toString());
                integerStack.push(count);
                count=0;
                sb=new StringBuilder();
            }
            else if(s.charAt(i)==']')
            {
                int times=integerStack.pop();
                StringBuilder temp=new StringBuilder();
                for(int j=1;j<=times;j++)
                {
                    temp.append(sb);
                }
                sb=new StringBuilder(stringStack.pop()+temp);
            }
            else if(s.charAt(i)>='0'&&s.charAt(i)<='9')
            {
                count=count*10+(int)(s.charAt(i)-'0');
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}