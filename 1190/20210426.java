class Solution {
    public String reverseParentheses(String s) {
        int right=0;
        int left=s.length();
        char[] ch=s.toCharArray();
        while(right<s.length()){
            if(ch[right]!=')'){
                right++;
                continue;
            }
            left=right;
            while(left>=0&&ch[left]!='('){
                left--;
            }
            ch[left]='0';
            ch[right]='0';
            reverse(ch,left+1,right-1);
            right++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='0'){
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] ch,int left,int right){
        while(left<right){
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
    }
}