class Solution {
    public String replaceSpace(String s) {
        int size=0;
        char[] charArray=new char[s.length()*3];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                charArray[size++]='%';
                charArray[size++]='2';
                charArray[size++]='0';
            }
            else
            {
                charArray[size++]=s.charAt(i);
            }
        }
        return new String(charArray,0,size);
    }
}