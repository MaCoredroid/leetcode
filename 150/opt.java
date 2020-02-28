class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack=new int[tokens.length/2+1];
        int index=0;
        for(String token:tokens)
        {
            switch(token)
            {
                case "+":
                {
                    stack[index-2]+=stack[--index];
                    break;
                }
                case "-":
                {
                    stack[index-2]-=stack[--index];
                    break;
                }
                case "*":
                {
                    stack[index-2]*=stack[--index];
                    break;
                }
                case "/":
                {
                    stack[index-2]/=stack[--index];
                    break;
                }
                default:
                {
                    stack[index++]=Integer.parseInt(token);
                }
            }
        }
        return stack[0];
    }
}