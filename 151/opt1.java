class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        if(s.equals(""))
        {
            return "";
        }
        String[] words=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--)
        {
            if(words[i].equals(""))
            {
                continue;
            }
            sb.append(words[i]).append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}