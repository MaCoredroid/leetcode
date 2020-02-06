class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    List<String> output = new ArrayList<String>();
    public void backTrack(String ans,String digits)
    {
        if(digits.length()==0)
        {
            output.add(ans);
            return;
        }
        String temp=map[digits.charAt(0)-'0'];
        for(int i=0;i<temp.length();i++)
        {
            backTrack(ans+temp.charAt(i),digits.substring(1,digits.length()));
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0)
        {
            backTrack("",digits);
        }
        return output;
    }
}