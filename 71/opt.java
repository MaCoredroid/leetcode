class Solution {
    public String simplifyPath(String path) {
        String[] s=path.split("/");
        Stack<String> stack=new Stack<>();
        for(int i=0;i<s.length;i++)
        {
            if(s[i].equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else if(!s[i].equals(".")&&!s[i].equals(""))
            {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty())
        {
            return "/";
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<stack.size();i++)
        {
            sb.append("/").append(stack.get(i));
        }
        return sb.toString();
    }
}