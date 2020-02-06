class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb= new StringBuilder();
        while(n>0)
        {
            int a=n%26;
            if(a==0)
            {
                a=26;
                n--;
            }
            sb.insert(0,(char)('A'+a-1));
            n/=26;
        }
        return sb.toString();
    }
}