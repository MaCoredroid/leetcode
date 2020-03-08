import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> res=new Stack<>();
        int i=0;
        int pushedpointer=-1;
        while(i<popped.length)
        {
            if(res.size()==0||res.peek()!=popped[i])
            {

                int pos=-1;
                for(int j=pushedpointer+1;j<pushed.length;j++)
                {
                    if(pushed[j]==popped[i])
                    {
                        pos=j;
                        break;
                    }
                }
                if(pos==-1)
                {
                    return false;
                }            
                for(int j=pushedpointer+1;j<pos;j++)
                {
                    res.push(pushed[j]);
                }
                pushedpointer=pos;
            }
            else
            {
                res.pop();
            }
            i++;
        }
        return true;
    }
}