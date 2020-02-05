class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int counter=0;
        StringBuilder str = new StringBuilder("");
        while(i>=0||j>=0||counter>0)
        {
            int a=i>=0?num1.charAt(i)-'0':0;
            int b=j>=0?num2.charAt(j)-'0':0;
            int ans=a+b+counter;
            if(ans>=10)
            {
                counter=1;
                ans-=10;
            } 
            else          
            {
                counter=0;
            }
            str.append(ans); 
            i--;
            j--;      
        }
        return str.reverse().toString();
    }
}