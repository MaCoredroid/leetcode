class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
        {
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            switch (c)
            {
                case '(':
                case '{':
                case '[':
                {
                    stack.push(c);
                    break;
                }
                case ')':
                {
                    if(!stack.empty()&&stack.peek()=='(')
                    {
                        stack.pop();
                        break;
                    }
                    else
                    {
                        return false;
                    }
                }
                case '}':
                {
                    if(!stack.empty()&&stack.peek()=='{')
                    {
                        stack.pop();
                        break;
                    }
                    else
                    {
                        return false;
                    }
                }
                case ']':
                {
                    if(!stack.empty()&&stack.peek()=='[')
                    {
                        stack.pop();
                        break;
                    }
                    else
                    {
                        return false;
                    }
                }
                default:
                {
                    return false;
                }

            }
        }
        if(!stack.empty())
        {
            return false;
        }
        return true;
    }
}