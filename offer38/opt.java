import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<String> ret=new ArrayList<>();
    public String[] permutation(String s) {
        char[] res=s.toCharArray();
        Arrays.sort(res);
        backTrack(res,0);
        return ret.toArray(new String[0]);
    }
    public void backTrack(char[] res,int i)
    {
        if(i==res.length)
        {
            ret.add(new String(res));
            return;
        }
        for(int j=i;j<res.length;j++)
        {
            if(canSwap(res,i,j))
            {
                char temp=res[i];
                res[i]=res[j];
                res[j]=temp;
                backTrack(res,i+1);
                res[j]=res[i];
                res[i]=temp;
            }
        }
    }
    private boolean canSwap(char[] res,int start, int end)
    {
        for(int i=start;i<end;i++)
        {
            if(res[i]==res[end])
            {
                return false;
            }
        }
        return true;
    }
}