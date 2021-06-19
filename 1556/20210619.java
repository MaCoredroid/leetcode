class Solution {
    public String thousandSeparator(int n) {
        String res=Integer.toString(n);
        char[] ch=res.toCharArray();
        StringBuilder sb=new StringBuilder();
        int m=ch.length;
        for(int i=m-1;i>=0;i--){
            if(i!=m-1&&(m-i-1)%3==0){
                sb.insert(0,'.');
            }
            sb.insert(0,ch[i]);
        }
        return sb.toString();
    }
}