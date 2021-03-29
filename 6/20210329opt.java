class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        char[] ch= s.toCharArray();
        for(int i=0;i<numRows;i++){
            int n=0;
            while(n*(2*numRows-2)-i<ch.length){
                if(n*(2*numRows-2)-i>=0){
                    sb.append(ch[n*(2*numRows-2)-i]);
                }
                if(i!=0&&i!=numRows-1&&n*(2*numRows-2)+i<ch.length){
                    sb.append(ch[n*(2*numRows-2)+i]);
                }
                n++;
            }
        }
        return sb.toString();
    }
}