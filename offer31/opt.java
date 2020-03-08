class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null||popped==null||pushed.length!=popped.length)
        {
            return false;
        }
        int top=0;
        int index=0;
        for(int push:pushed)
        {
            pushed[top++]=push;
            while(top>0&&pushed[top-1]==popped[index])
            {
                top--;
                index++;
            }
        }
        return top==0;
    }
}