class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        char[] ch= s.toCharArray();
        int step=(2*numRows-2);
        for(int i=0;i<numRows;i++){
            int n=0;
            while(n*step-i<ch.length){
                if(n*step-i>=0){
                    sb.append(ch[n*step-i]);
                }
                if(i!=0&&i!=numRows-1&&n*step+i<ch.length){
                    sb.append(ch[n*step+i]);
                }
                n++;
            }
        }
        return sb.toString();
    }
}