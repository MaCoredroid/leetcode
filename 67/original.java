class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int counter=0;
        StringBuilder ret=new StringBuilder();
        while(i>=0||j>=0||counter>0) 
        {
            int addition1=i>=0?a.charAt(i)-'0':0;
            int addition2=j>=0?b.charAt(j)-'0':0;
            int ans=addition1+addition2+counter;
            if(ans>=2)
            {
                counter=1;
                ans-=2;
            }
            else
            {
                counter=0;
            }
            ret.append(ans);
            i--;
            j--;
        }
        return ret.reverse().toString();
    }
}