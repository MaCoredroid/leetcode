class Solution {
    public List<String> letterCombinations(String digits) {
        String[] res =new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ret=new ArrayList<>();
        if(digits.equals(""))
        {
            return ret;
        }
        ret.add("");
        for(int i=0;i<digits.length();i++)
        {
            String target=res[digits.charAt(i)-'0'];
            List<String> ans=new ArrayList<>();
            for(String oneString:ret)
            {
                for(int j=0;j<target.length();j++)
                {
                    ans.add(oneString+target.charAt(j));
                }
            }
            ret=ans;
        }
        return ret;
    }
}