class Solution {
    public int maximum69Number (int num) {
        String a=Integer.toString(num);
        char[] ch=a.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='6'){
                ch[i]='9';
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }
}