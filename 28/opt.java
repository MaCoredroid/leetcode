class Solution {
    public String countAndSay(int n) {
        String temp="1";
        while(n>1)
        {
            temp=say(temp);
            n--;
        }
        return temp;
    }
    private String say(String temp)
    {
        StringBuilder sb = new StringBuilder();
        char pre = temp.charAt(0);
        int count=1;
        for(int i=1;i<temp.length();i++)
        {
            if(temp.charAt(i)==pre)
            {
                count++;
            }
            else
            {
                sb.append(count).append(pre);
                count=1;
                pre=temp.charAt(i);
            }
        }
        sb.append(count).append(pre);
        return sb.toString();
    }
}