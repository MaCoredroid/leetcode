import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ret=new ArrayList<>();

    public void backTrack(String digits,StringBuilder ans,int i)
    {
        if(digits.length()==i)
        {
            ret.add(ans.toString());
            return;
        }
        String temp=map[digits.charAt(i)-'0'];
        for(int j=0;j<temp.length();j++)
        {
            ans.append(temp.charAt(j));
            backTrack(digits,ans,i+1);
            ans.delete(ans.length()-1,ans.length());
        }
    }

   
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0)
        {
            backTrack(digits,new StringBuilder(),0);
        }
        return ret;
    }
}