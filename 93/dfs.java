class Solution {  
    String temp="";
    List<String> result=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) 
    {
        temp=s;
        dfs("",0,4);
        return result;
    }
    public void dfs(String before, int startIndex, int count)
    {
        int left=temp.length()-startIndex;
        if(left>count*3||left<count)
        {
            return;
        }
        if(count==0)
        {
            if(startIndex==temp.length())
            {
                result.add(before.substring(1));
            }
            return;
        }
        dfs(before+"."+temp.substring(startIndex,startIndex+1),startIndex+1,count-1);
        if(temp.charAt(startIndex)!='0')
        {
            if(startIndex+2<=temp.length())
            {
                dfs(before+"."+temp.substring(startIndex,startIndex+2),startIndex+2,count-1);
            }
            if(startIndex+3<=temp.length()&&Integer.valueOf(temp.substring(startIndex,startIndex+3))<=255)
            {
                dfs(before+"."+temp.substring(startIndex,startIndex+3),startIndex+3,count-1);
            }

        }
    }
}