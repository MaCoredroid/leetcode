class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] ch = new char[]{'0','1','2','3','4','5','6','7','8','9','a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            int temp=num&15;
            sb.insert(0,ch[temp]);
            num>>>=4;
        }
        return sb.toString();
    }
}